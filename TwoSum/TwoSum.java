package TwoSum;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args){
        int[] nums = {2,11,5,3,7,14,9,15};
        System.out.println(twoSum(nums, 13)[0]+", "+twoSum(nums, 13)[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(nums[i])){
                ans[0] = map.get(nums[i]);
                ans[1] = i; 
            }
            else{
                map.put(value, i);
            }
        }
        return ans;
    }
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Solution");
    }

}
