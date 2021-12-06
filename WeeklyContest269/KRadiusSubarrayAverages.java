package WeeklyContest269;

public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k){
        long sum = 0;
        int n = nums.length, mod = k << 1;
        if(k == 0){
            return nums;
        }
        int[] res = new int[n];

        for(int i = 0; i < k; i++){
            res[i] = res[n - i - 1] = -1;
            sum += nums[i];
        }

        for(int i = k; i < n; i++){
            if(i < mod) sum += nums[i];
            else{
                res[i - k] = (int)(sum / mod);
                sum -= nums[i - mod]; 
            }
        }
    
        return res;
    }
    
}
