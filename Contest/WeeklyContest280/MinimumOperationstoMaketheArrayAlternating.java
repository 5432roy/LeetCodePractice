package WeeklyContest280;
import java.util.*;
public class MinimumOperationstoMaketheArrayAlternating {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> even = new HashMap<>();
        HashMap<Integer,Integer> odd = new HashMap<>();

        for(int i = 0; i < nums.length; i+=2 ){
            even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 1; i < nums.length; i += 2){
            odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        }

        int evenMax = 0, evenSec = 0, oddMax = 0, oddSec = 0, memo1 = 0, memo2 = 0;

        for(int key : even.keySet()){
            int cur = even.get(key);
            if(cur > evenMax){
                evenMax = cur;
                memo1 = cur;
            }
            else if(cur > evenSec){
                cur = evenSec;
            }
        }

        for(int key : odd.keySet()){
            int cur = odd.get(key);
            if(cur > oddMax){
                oddMax = cur;
                memo2 = cur;
            }
            else if(cur > oddSec){
                cur = oddSec;
            }
        }

        return memo1 == memo2 ? nums.length - (Math.max(evenMax + oddSec, evenSec + oddMax)) : (nums.length - evenMax - oddMax);
    }
    
}

// [2,2,2,2,2,2,1,0,1]
// [1,2,1,2,1,2,1,2,1]