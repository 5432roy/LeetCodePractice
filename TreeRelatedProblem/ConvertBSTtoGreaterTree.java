public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode node) {
        helper(node);
        return node;
    }

    int temp = 0;
    private void helper(TreeNode node) {
        if(node == null) return;

        helper(node.right);

        temp += node.val;

        node.val = temp;
        
        helper(node.left);
    }
    
}
