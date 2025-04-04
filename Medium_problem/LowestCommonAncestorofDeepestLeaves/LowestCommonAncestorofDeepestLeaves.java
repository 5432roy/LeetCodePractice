/*
 * 1123. Lowest Common Ancestor of Deepest Leaves
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/?envType=daily-question&envId=2025-04-04
 * 
 * First find out the deepest node count (BFS)
 * Then find out the first node that contains this many node at the deepest level (DFS)
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = -1, count = 0;

        while(!q.isEmpty()) {
            depth++;
            count = 0;
            for(int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                count++;
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }
        List<TreeNode> list = new ArrayList<>();
        findNode(root, 0, depth, count, list);
        return list.get(0);
    }

    private int findNode(TreeNode node, int cur, int maxDepth, int count, List<TreeNode> list) {
        if(!list.isEmpty() || node == null) {
            return 0;
        }

        if(cur == maxDepth) {
            if(count == 1) {
                list.add(node);
                return 0;
            }
            return 1;
        }

        int left = findNode(node.left, cur + 1, maxDepth, count, list);
        int right = findNode(node.right, cur + 1, maxDepth, count, list);
        int sum = left + right;

        if(count == sum && list.isEmpty()) {
            list.add(node);
            return 0;
        }
        
        return sum;
    }
}