package TreeRelatedProblem;
public class FlattenBSTtoLinkedList {
    public void flatten(TreeNode node){
        if(node == null) return;
        flatten(node.left);
        if(node.left != null){
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            TreeNode end = node.right;
            while(end.right != null) end = end.right;
            end.right = temp;
        }
        flatten(node.right);
    }


}
