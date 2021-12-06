package TreeRelatedProblem;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root){
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);

    }
    
}
