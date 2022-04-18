package TreeRelatedProblem;
import java.util.*;
public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(list, root);
        return list.get(k - 1);
    }
    
    private void helper(ArrayList<Integer> list , TreeNode node) {
        if(node == null) return;
        
        helper(list, node.left);
        
        list.add(node.val);
        
        helper(list, node.right);
    }
}
