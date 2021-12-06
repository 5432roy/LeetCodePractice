package DecodeWaysII;

public class DecodeWaysII {

    public static void main(String[] args){
        String s = "*1712*";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        int MOD = 1000000007;
        long[] memo = new long[s.length() + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                memo[i + 1] = 9 * memo[i] % MOD;
                if (s.charAt(i - 1) == '1')
                    memo[i + 1] = (memo[i + 1] + 9 * memo[i - 1]) % MOD;
                if (s.charAt(i - 1) == '2')
                    memo[i + 1] = (memo[i + 1] + 6 * memo[i - 1]) % MOD;
                if (s.charAt(i - 1) == '*')
                    memo[i + 1] = (memo[i + 1] + 15 * memo[i - 1]) % MOD;
            } else {
                memo[i + 1] = s.charAt(i) != '0' ? memo[i] : 0;
                if (s.charAt(i - 1) == '1')
                    memo[i + 1] = (memo[i + 1] + memo[i - 1]) % MOD;
                if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    memo[i + 1] = (memo[i + 1] + memo[i - 1]) % MOD;
                if (s.charAt(i - 1) == '*')
                    memo[i + 1] = (memo[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * memo[i - 1]) % MOD;
            }
        }
        return (int) memo[s.length()];
    }
    
}
