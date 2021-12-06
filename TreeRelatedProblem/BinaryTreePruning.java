package TreeRelatedProblem;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root){
        if(!helper(root)) return null;
        return root;
    }

    private boolean helper(TreeNode node){
        if(node.left != null && node.right != null){
            boolean left = helper(node.left), right = helper(node.right);
            if(!left) node.left = null;
            if(!right) node.right = null;
            return left || right;
        }
        if(node.left != null){ 
            boolean left = helper(node.left);
            if(!left) node.left = null;
            return left;
        }

        if(node.right != null){ 
            boolean right = helper(node.right);
            if(!right) node.right = null;
            return right;
        }

        if(node.val == 1) return true;
        return false;
    }
    
}
