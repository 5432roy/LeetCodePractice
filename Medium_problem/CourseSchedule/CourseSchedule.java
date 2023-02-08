package CourseSchedule;
import java.util.*;
public class CourseSchedule {
    
    int[] canTake;
    public boolean canFinish(int num, int[][] pres){
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        canTake = new int[num];
        for(int[] i : pres){
            map.putIfAbsent(i[0], new ArrayList<Integer>());
            map.get(i[0]).add(i[1]);
        }
        for(int i = 0; i < num; i++){
            dfs(map, i);
            if(canTake[i] == -1) return false;
        }
        return true;
    }
    List<Integer> list = new ArrayList<>();
    public int dfs(HashMap<Integer,List<Integer>> map, int index){
        if(canTake[index] != 0) return canTake[index];
        int res = 1;
        if(map.containsKey(index)){
            if(list.contains(index)) return canTake[index] = -1;
            list.add(index);
            for(int i : map.get(index)){
                res = Math.min(res, dfs(map, i));
            }
            list.remove(list.size() - 1);
        }
        return canTake[index] = res;
    }
    
}
