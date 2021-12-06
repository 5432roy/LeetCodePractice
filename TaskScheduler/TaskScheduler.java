package TaskScheduler;

import java.util.HashMap;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, nums = 1;
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
            if(map.get(task) == max) nums++;
            if(map.get(task) > max){
                max = map.get(task);
                nums = 1;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + nums); 
    }
    
}
