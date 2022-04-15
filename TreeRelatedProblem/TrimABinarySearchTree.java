package TreeRelatedProblem;

public class TrimABinarySearchTree {
    
    public TreeNode trimBST(TreeNode node, int low, int high) {
        if(node == null) return null;

        if(node.val < low){
            node.left = null;
            node = trimBST(node.right, low, high);
        }
        else if(node.val > high){
            node.right = null;
            node = trimBST(node.left, low, high);
        }
        else {
            node.left = trimBST(node.left, low, high);
            node.right = trimBST(node.right, low, high);
        }
        
        return node;
    }

    
}
