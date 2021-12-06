package BestSightseeingPair;

public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values){
        int[] dp = new int[values.length];
        dp[0] = values[0] - 1;
        int res = 0;
        for(int i = 1; i < values.length; i++){
            dp[i] = Math.max(values[i], dp[i - 1] - 1);
            res = Math.max(res, dp[i - 1] + values[i]);
        }

        return res;
    }
    
}
