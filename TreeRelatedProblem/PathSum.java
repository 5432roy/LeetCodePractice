package TreeRelatedProblem;

public class PathSum {

    public boolean hasPathSum(TreeNode node, int target){
        if(node == null) return false;
        target -= node.val;
        if(node.left == null && node.right == null && target == 0) return true;

        return hasPathSum(node.left, target) || hasPathSum(node.right, target);
    }
    
}
