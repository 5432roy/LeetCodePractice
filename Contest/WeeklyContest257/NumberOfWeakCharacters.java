package WeeklyContest257;
import java.util.*;
public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {
        int res = 0;
        Arrays.sort(properties, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1] - b[1];
                return  b[0] - a[0];
            }
        });
        int max = 0;
        for(int i = 0; i < properties.length; i++){
            if(properties[i][1] < max){
                res++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return res;
    }
    
}
