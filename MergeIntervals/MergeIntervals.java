package MergeIntervals;
import java.util.*;
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0], prev = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > prev) {
                list.add(new int[]{start, prev});
                start = intervals[i][0];
            }
            prev = Math.max(prev, intervals[i][1]);
        }
        list.add(new int[]{start, prev});
        
        int[][] res = new int[list.size()][2];
        int i = 0;
        for(int[] nums : list) {
            res[i++] = nums;
        }

        return res;
    }
    
}
