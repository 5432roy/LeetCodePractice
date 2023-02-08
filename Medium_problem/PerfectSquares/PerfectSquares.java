package PerfectSquares;

public class PerfectSquares {

    /*  O(n^(1.5)), using dp 
        public int numSquares(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, 1 << 30);
        memo[0] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }
        
        return memo[n];
    }
    */
    public int numSquares(int n){
        int[] memo = new int[n + 1];
        memo[0] = 0;
        return backTracking(n, memo); 
    }
    
    private int backTracking(int n, int[] memo){
        if(n < 0) return 1 << 30;
        if(memo[n] != 0 || n == 0) return memo[n];
        
        int root = (int)Math.sqrt(n);
        int res = Integer.MAX_VALUE;
        
        for(int i = root; i > 0; i--){
            res = Math.min(res, backTracking(n - (i * i), memo));
        }

        return memo[n] = res + 1;
    }
}
