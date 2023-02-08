package WeeklyContest270;
import java.util.*;
public class ValidArrangementofPairs {
    
    public int[][] validArrangement(int[][] pairs) {
        int[][] res = new int[pairs.length][2];
        
        HashMap<Integer,Integer> head = new HashMap<>();
        HashMap<Integer,Integer> tail = new HashMap<>();

        for(int[] pair : pairs){
            tail.put(pair[0], tail.getOrDefault(pair[0], 0) - 1);

        }


        
        return res;
    }
    
}
