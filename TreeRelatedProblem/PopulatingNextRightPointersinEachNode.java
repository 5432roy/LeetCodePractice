package TreeRelatedProblem;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                Node cur = queue.poll();
                if(cur != null){
                    if(cur.left != null) queue.add(cur.left);
                    if(cur.right != null) queue.add(cur.right);
                    if(i > 1){
                    cur.next = queue.peek();
                    }
                }
            }
        }
        return root;
    }
    
}
