package WeeklyContest265;
import java.util.*;
public class MinimumOperationsToConvertNumber {
    
    // using bfs to brute force it, instead of thinking about any math technic
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        HashSet<Integer> set = new HashSet<>();

        int res = 0;
        while(!queue.isEmpty()){

            for(int i = queue.size(); i > 0; i--){
                int cur = queue.poll();

                if(cur == goal) return res;

                if(cur < 0 || cur > 1000 || set.contains(cur)) continue;

                set.add(cur);

                for(int num : nums){
                    queue.offer(cur + num);
                    queue.offer(cur - num);
                    queue.offer(cur ^ num);
                }
            }
            res++;
        }

        return -1;
    }
    
}
