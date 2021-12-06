package TreeRelatedProblem;

public class RecoverBST {

    public void recoverTree(TreeNode root) {
        while(change){
            change = false;
            helper(root);
        }
        
        return;
    }
    boolean change = true;;
    private void dfs(TreeNode minNode, TreeNode maxNode, TreeNode cur){
        if(cur == null) return;
        
        if(cur.val < minNode.val){
            int temp = cur.val;
            cur.val = minNode.val;
            minNode.val = temp;
            change = true;
        }
        else if(cur.val > maxNode.val){
            int temp = cur.val;
            cur.val = maxNode.val;
            maxNode.val = temp;
            change = true;
        }
        
        dfs(minNode, cur, cur.left);
        dfs(cur, maxNode, cur.right);
    }
    
    private void helper(TreeNode node){
        if(node == null) return;
        TreeNode minNode = new TreeNode(Integer.MIN_VALUE);
        TreeNode maxNode = new TreeNode(Integer.MAX_VALUE);
        helper(node.left);
        helper(node.right);
        dfs(minNode, maxNode, node);
        return;
    }
    
}
