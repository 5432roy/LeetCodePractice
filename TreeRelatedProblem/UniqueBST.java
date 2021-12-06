package TreeRelatedProblem;

public class UniqueBST {

    public int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        
        // numbers of combination when n is i;
        for(int i = 2; i <= n; i++){
            // numbers of combination when j is the root from number 1 to i
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j]; 
            }
        }

        return dp[n];
    }
    
}
