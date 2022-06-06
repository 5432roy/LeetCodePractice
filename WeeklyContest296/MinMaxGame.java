package WeeklyContest296;

public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        while(nums.length > 1) {
            int[] newNums = new int[nums.length >> 1];
            //System.out.println(newNums.length);
            for(int i = 0; i < newNums.length; i++) {
                int index = i << 1;
                if(i % 2 == 0) {
                    newNums[i] = Math.min(nums[index],nums[index + 1]);
                }
                else {
                    newNums[i] = Math.max(nums[index],nums[index + 1]);
                }
            }
            nums = new int[newNums.length];
            nums = newNums.clone();
            
        }
        return nums[0];
    }
}
