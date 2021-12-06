package PalindromePartitioning;
import java.util.*;
public class PalindromePartitioning {

    public List<List<String>> partition(String str){
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dp = new int[str.length()][str.length()];
        buildList(str, 0, list, ans);
        return ans;
    }

    private void buildList(String str, int position, List<String> list, List<List<String>> ans){
        if(position == str.length()) ans.add(new ArrayList<String>(list));
        else{
            for(int i = position; i < str.length(); i++){
                if(isPalindrome(position, i, str) == 1){
                    list.add(str.substring(position, i + 1));
                    buildList(str, i + 1, list, ans);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    int[][] dp;
    private int isPalindrome(int head, int tail, String str){
        if(tail - head < 3) return dp[head][tail] = str.charAt(head) == str.charAt(tail) ? 1 : -1;
        if(dp[head + 1][tail - 1] == 0){
            return dp[head + 1][tail - 1] = isPalindrome(head + 1, tail - 1, str);
        }
        if(dp[head + 1][tail - 1] == 1){
            return dp[head][tail] = str.charAt(head) == str.charAt(tail) ? 1 : -1;
        }
        return dp[head][tail] = -1;
    }



    
}
