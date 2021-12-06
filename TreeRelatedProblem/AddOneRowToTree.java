package TreeRelatedProblem;

public class AddOneRowToTree { 

    public TreeNode addOneRow(TreeNode root, int val, int row){
        if(row == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, val, row, 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int row, int cur){
        if(node == null) return;
        if(cur + 1 == row){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            if(node.left == null){
                node.left = left;
            }
            else{
                left.left = node.left;
                node.left = left;
            }
            if(node.right == null){
                node.right= right;
            }
            else{
                right.right = node.right;
                node.right = right;
            }
            return;
        }
        dfs(node.left, val, row, cur + 1);
        dfs(node.right, val, row, cur + 1);
    }
    
}
