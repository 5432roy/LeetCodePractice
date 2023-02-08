package KthLargestInArray;
import java.util.*;
public class KthLargest {

    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums){
            heap.add(i);
        }
        while(k > 1){
            heap.poll();
            k--;
        }
        return heap.peek();
    }
    
}
