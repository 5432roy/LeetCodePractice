package WeeklyContest259;

public class Second {

    public int sumOfBeauties(int[] nums) {
        int res = 0, n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        max[0] = nums[0];
        min[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++){
            max[i] = Math.max(max[i - 1], nums[i]);
            min[n - i] = Math.min(min[n - i], nums[n - i - 1]);
        }

        for(int i = 1; i < n - 1; i++){
            if(nums[i] < min[i + 1] && nums[i] > max[i - 1]){
                res += 2;
            }
            else if(nums[i] < nums[i + 1] && nums[i] > nums[i - 1]){
                res++;
            }
        }

        return res;
    }
    
}
