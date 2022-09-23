package ConcatenationofConsecutiveBinaryNumbers;

public class ConcatenationofConsecutiveNumbers {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1000000007;
        
        for(int i = 1; i <= n; i++) {
            int cur = i, len = 0;
            while(cur > 0) {
                cur /= 2;
                len++;
            }
            res = ((res << len) + i) % mod;
        }
        
        return (int)res;
    }
}
