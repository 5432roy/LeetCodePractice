package TreeRelatedProblem;

import java.util.*;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                TreeNode cur = queue.poll();
                if(cur != null){
                    if(i == 1) ans.add(cur.val);
                    if(cur.left != null) queue.offer(cur.left);
                    if(cur.right != null) queue.offer(cur.right);
                }
            }
        }

        return ans;
    }
    
}
