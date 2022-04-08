package Easy;
import java.util.*;
public class KthLargestElementinaStream {

    PriorityQueue<Integer> queue;
    int k;
    public KthLargestElementinaStream(int k, int[] nums) {
        
        this.queue = new PriorityQueue<Integer>();
        this.k = k;
        
        for(int i : nums){
            helper(i);
        }
    }
    
    public int add(int val) {
        helper(val);
        
        return queue.peek();
    }
    
    private void helper(int i){
        if(queue.size() < k) queue.add(i);
        else if(i > queue.peek()){
            this.queue.add(i);
            this.queue.poll();
        }
    }
    
}
