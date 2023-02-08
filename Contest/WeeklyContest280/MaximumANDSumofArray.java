package WeeklyContest280;
import java.util.*;
public class MaximumANDSumofArray {
    public int maximumANDSum(int[] nums, int numSlots) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] slots = new int[numSlots + 1];
        Arrays.fill(slots, 2);
        int res = 0;

        for(int i : nums) list.add(i);
        Collections.sort(list);

        for(int num : list){
            int memo = 0, cur = 0;
            for(int i = 1; i <= numSlots; i++ ){
                if(slots[i] < 1) continue;

                int temp = num & i;
                if(temp > cur){
                    memo = i;
                    cur = temp;
                }
            }
            slots[memo]--;
            res += cur;
        }
        return res;
    }
    
}
