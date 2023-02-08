package WeeklyContest264;

public class NextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        int a;
        int res = 0;
        int digit = digit(n);
        int leading = n / (int)Math.pow(10, digit - 1);

        if(leading >= digit){
        }

        return res;
    }

    private int digit(int n){
        int i = 0;
        while(n > 0){
            i++;
            n /= 10;
        }
        return i;
    }
    
}
