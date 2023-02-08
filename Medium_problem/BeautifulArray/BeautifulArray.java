package BeautifulArray;
public class BeautifulArray {

    public int[] beautifulArray(int n){
        if(n == 1) return new int[]{1};
        if(n == 2) return new int[]{1,2};
        int[] ans = new int[n];
        ans[0] = 1;
        ans[n - n / 2] = 2;
        boolean isEven = n % 2 == 0;

        int cur = n - (isEven? 1 : 0), index = 1;
        while(cur > 1){
            ans[index] = cur;
            index++;
            cur -= 4;
        }
        cur = 3;
        while(cur <= n){
            ans[index] = cur;
            index++;
            cur += 4;
        }

        return ans;
    }
    
}
