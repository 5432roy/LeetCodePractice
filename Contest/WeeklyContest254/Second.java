package WeeklyContest254;

import java.util.*;

public class Second {

    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        PriorityQueue<Integer> even1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even2 = new PriorityQueue<>();
        PriorityQueue<Integer> odd1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd2 = new PriorityQueue<>();
        for(int i : nums){
            if(i % 2 == 0) {
                even1.add(i);
                even2.add(i);
            }
            else {
                odd1.add(i);
                odd2.add(i);
            }
        }
        int index = 0;
        int prev = Integer.MIN_VALUE;
        boolean swap = true;
        while(!even1.isEmpty() && even2.peek() != prev && even1.peek() != prev){
            if(swap){
                res[index] = even1.poll();
            }
            else{
                res[index] = even2.poll();
            }
            swap = !swap; 
            prev = res[index];
            index++;
        }
        swap = true;
        while(!odd1.isEmpty() && odd2.peek() != prev && odd1.peek() != prev){
            if(swap){
                res[index] = odd1.poll();
            }
            else{
                res[index] = odd2.poll();
            }
            swap = !swap; 
            prev = res[index];
            index++;
        }
        return res;
    }
    
}
