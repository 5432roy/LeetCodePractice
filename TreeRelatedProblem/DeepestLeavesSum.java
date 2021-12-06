package TreeRelatedProblem;
import java.util.*;
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0, i;
        queue.offer(root);

        while(!queue.isEmpty()){
            for(i = queue.size(), sum = 0; i > 0; i--){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            if(queue.isEmpty()){
                return sum;
            }
        }
        
        return -1;
    }
    
}
