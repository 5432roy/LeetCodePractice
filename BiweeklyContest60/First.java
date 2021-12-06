package BiweeklyContest60;

public class First {

    public int findMiddleIndex(int[] nums){
        int sum = 0, n = nums.length;
        for(int i  : nums){
            sum += i;
        }
        int leftSum = 0;
        for(int i = 0; i < n; i++){
            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
    
}
