package TreeRelatedProblem;
import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean level = true;
        while(!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode cur = queue.poll();

                if(cur != null){
                    curLevel.add(cur.val);
                    if(level){
                        stack.add(cur.left);
                        stack.add(cur.right);
                    }
                    else{
                        stack.add(cur.right);
                        stack.add(cur.left);
                    }
                }
            }
            while(!stack.isEmpty()){
                queue.add(stack.pop());
            }
            if(curLevel.size() != 0)
                list.add(curLevel);
            level = !level;
        }

        return list;
    }
    
}
