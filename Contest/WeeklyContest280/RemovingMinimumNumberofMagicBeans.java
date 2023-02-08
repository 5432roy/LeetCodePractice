package WeeklyContest280;
import java.util.*;
public class RemovingMinimumNumberofMagicBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        
        long res = Long.MAX_VALUE, sum = 0, n = beans.length;
        
        for(int i : beans) sum += i;
        
        for(int i = 0; i < n; i++){
            res = Math.min(res, sum - beans[i] * (n - i));
            sum = sum - beans[i];
        }

        return res;
    }
}
