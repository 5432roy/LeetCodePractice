package WeeklyContest258;
import java.util.*;
public class Second {
    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0;
        HashMap<Double,Integer> map = new HashMap<>();

        for(int[] rectangle : rectangles){
            double w = rectangle[0], h = rectangle[1];
            double ratio = w / h;
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }

        for(double key : map.keySet()){
            long cur = (long)map.get(key);
            res += cur * (cur - 1) /2;
        }


        return res;
    }
}
