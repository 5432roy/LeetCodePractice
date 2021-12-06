package TreeRelatedProblem;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowest(TreeNode root, TreeNode p, TreeNode q){
        boolean sameLeaf = true;
        while(sameLeaf){
            if(root == p) return p;
            if(root == q) return q;
            if(p.val > root.val != q.val > root.val) return root;
            
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }

        }
        return root;
    }
    
}
