package BestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] nums){
        int n = nums.length;
        int[][] profit = new int[n][3];

        for(int i = 1; i <= 2; i++){
            int min = nums[0];
            for(int j = 1; j < n; j++){
                min = Math.min(min, nums[j] - profit[j - 1][i - 1]);
                profit[j][i] = Math.max(profit[j - 1][i], nums[j] - min);
            }
        }
        return profit[n - 1][2];
        //abc
    }
}
