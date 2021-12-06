package WeeklyContest256;
import java.util.*;
public class Third {
    //not
    public int minSessions(int[] tasks, int sessionTime){
        int a;
        int n = tasks.length;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(tasks);
        list.add(0);
        for(int i = n - 1; i >= 0; i--){
            int j;
            for(j = 0; j < list.size(); j++){
                if(list.get(j) + tasks[i] <= sessionTime){
                    int cur = list.get(j) + tasks[i];
                    list.set(j, cur);
                    break;
                }
            }
            if(j == list.size()) list.add(tasks[i]);
        }

        return list.size();
    }
    
}
