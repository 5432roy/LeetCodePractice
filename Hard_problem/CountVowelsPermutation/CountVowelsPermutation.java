package CountVowelsPermutation;

public class CountVowelsPermutation {
    public static long counts = 0;
    public static void main(String[] args){

        int i = 50;
        System.out.println(countVowelPermutation(i));

    }
    static int countVowelPermutation(int n){
        int sum = 0;
        int MOD = 1000000007;
        long[][] memo = new long[5][n];
        for(int i = 0; i < 5; i++){
            sum = (sum + (int)recursive(n-1, i, memo)) % MOD;
        }
        return sum;
    }

    public static long recursive(int n, int ch, long[][] memo){
        long MOD = 1000000007;
        if(n == 0) return 1;
        if(memo[ch][n] != 0){
            return memo[ch][n];
        }

        if(ch == 0){
            memo[0][n] = recursive(n-1, 1, memo) % MOD ;
            return  memo[0][n];
        }
        if(ch == 1){
            memo[1][n] = (recursive(n-1, 0, memo) % MOD + recursive(n-1, 2, memo) % MOD) % MOD;
            return memo[1][n];
        }
        if(ch == 2){
            memo[2][n] = (recursive(n-1, 0, memo) % MOD + recursive(n-1, 1, memo) % MOD + recursive(n-1, 3, memo) % MOD + recursive(n-1, 4, memo) % MOD) % MOD;
            return  memo[2][n];
        }
        if(ch == 3){
            memo[3][n] = (recursive(n-1, 2, memo) % MOD + recursive(n-1, 4, memo) % MOD) % MOD;
            return memo[3][n];
        }
        // given that the ch can only be 0-4, we don't need another if statement to check
            memo[4][n] = recursive(n-1, 0, memo) % MOD;
            return memo[4][n];
    }
}
