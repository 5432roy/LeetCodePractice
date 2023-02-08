package IncreasingTripletSubsequence;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        Integer[] memo = new Integer[3];
        int index = 0;
        memo[0] = nums[0];
        for(int num : nums) {
            if(num == memo[index]) continue;
            if(num < memo[index]) {
                if(num < memo[0]) {
                    memo[0] = num;
                }
                else if(num > memo[0]){
                    memo[index] = num;   
                }
            }
            else {
                memo[++index] = num;
            }
            if(index == 2) return true;
        }
        return false;
    }
}
