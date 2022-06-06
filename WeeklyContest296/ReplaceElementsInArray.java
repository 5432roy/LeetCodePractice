package WeeklyContest296;
import java.util.HashMap;
public class ReplaceElementsInArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> index = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        
        for(int[] operation : operations) {
            nums[index.get(operation[0])] = operation[1];
            index.put(operation[1], index.get(operation[0]));
            index.remove(operation[0]);
        }
        
        return nums;
    }
    
}
