package BiweeklyContest58;

public class Fourth {

    public long maxProduct(String s) {
        int[] dp = new int[s.length()];
        long res = 1;
        for(int i = 0; i < s.length(); i++){
            if(dp[i] == 0){
                dp[i] = find(s, i, 0, 0);
            }
            int head2 = i + dp[i] + 1;
            for(int j = head2; j < s.length(); j++){
                if(dp[j] == 0){
                    dp[j] = find(s, j, 0, head2);
                }
                res = Math.max(res, (dp[i] * 2 + 1) * (dp[j] * 2 + 1));
            }
        }

        return res;
    }

    public  int find(String s, int mid, int length, int edge){
        int head = mid - length, tail = mid + length;
        if(head < edge || tail >= s.length() || s.charAt(head) != s.charAt(tail)) return length - 1;
        return find(s, mid, length + 1, edge);
    }
    
}
