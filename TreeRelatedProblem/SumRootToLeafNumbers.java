package TreeRelatedProblem;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : dfs(root, new StringBuilder());
    }

    private int dfs(TreeNode node, StringBuilder cur){
        cur = cur.append(node.val);
        
        if(node.left == node.right){
            int res = Integer.parseInt(cur.toString());
            cur.setLength(cur.length() - 1);
            return res;
        }

        int temp = (node.left == null ? 0 : dfs(node.left, cur)) + (node.right == null ? 0 : dfs(node.right, cur));
        cur.setLength(cur.length() - 1);

        return temp;
    }
    
}
