package TreeRelatedProblem;

public class ValidBST {

    public boolean isValidBST(TreeNode root){
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean helper(TreeNode node, long max, long min){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return helper(node.left, node.val, min) && helper(node.right, max, node.val);
    }
}
