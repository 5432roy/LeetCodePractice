package TreeRelatedProblem;

import java.util.ArrayList;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        
        TreeNode newRoot = new TreeNode();
        TreeNode cur = newRoot;
        
        for(int i : list){
            TreeNode newNode = new TreeNode(i);
            cur.right = newNode;
            cur = cur.right;
        }
        
        return newRoot.right;
    }
    
    private void helper(TreeNode node, ArrayList<Integer> list){
        if(node == null) return;
        
        helper(node.left, list);
        
        list.add(node.val);
        
        helper(node.right, list);
        
    }
    
}
