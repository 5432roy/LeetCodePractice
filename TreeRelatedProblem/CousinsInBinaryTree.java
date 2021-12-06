package TreeRelatedProblem;
import java.util.*;
public class CousinsInBinaryTree {
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode cur = queue.poll();
                int child = 0;
                if(cur.left !=  null){
                    level.add(cur.left.val);
                    queue.offer(cur.left);
                    child++;
                }
                if(cur.right != null){
                    level.add(cur.right.val);
                    queue.offer(cur.right);
                    child++;
                }
                if(child == 2){
                    if(cur.left.val == x && cur.right.val == y) return false;
                    if(cur.left.val == y && cur.right.val == x) return false;
                }
            }
            if(level.contains(x) && level.contains(y)) return true;
        }

        return false;
    }
}
