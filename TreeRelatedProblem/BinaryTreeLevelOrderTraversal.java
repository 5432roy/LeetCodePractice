package TreeRelatedProblem;
import java.util.*;
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode current = queue.poll();
                if(current != null){
                    curLevel.add(current.val);
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
            if(curLevel.size() != 0)
                list.add(0, curLevel);
        }
        return list;
    }
    
}
