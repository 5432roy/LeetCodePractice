package TopKFrequentElements;
import java.util.*;
public class TopKFrequentElements {
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);    
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int i : map.keySet()){
            if(queue.size() < k) queue.offer(new int[]{i, map.get(i)});  
            else if(queue.peek()[1] < map.get(i)){
                queue.poll();
                queue.offer(new int[]{i, map.get(i)});
            }
        }
        
        int index = 0;
        int[] res = new int[k];
        for(int[] i : queue) res[index++] = i[0];
        
        
        return res;
    }
}
