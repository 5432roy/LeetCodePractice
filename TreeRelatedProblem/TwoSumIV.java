package TreeRelatedProblem;
import java.util.*;
public class TwoSumIV {

    public boolean findTarget(TreeNode node, int k) {
        List<Integer> list = new ArrayList<>();
        
        helper(node, list);
        int head = 0, tail = list.size() - 1;

        while(tail > head){
            int cur = list.get(head) + list.get(tail);
            if(cur == k) return true;
            if(cur > k) tail--;
            else head++;
        }
        return false;
    }
    
    public void helper(TreeNode node, List<Integer> list){
        if(node == null) return;
        
        helper(node.left, list);
        
        list.add(node.val);
        
        helper(node.right, list);
    }
}
