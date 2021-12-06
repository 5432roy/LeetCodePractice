package TreeRelatedProblem;

public class SameTree {

    public static void main(String[] args){
        TreeNode p = new TreeNode(0);
        TreeNode leftP = new TreeNode(-5);
        p.left = leftP;

        TreeNode q = new TreeNode(0);
        TreeNode leftQ = new TreeNode(-8);
        q.left = leftQ;

        isSameTree(p, q);

    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
}
