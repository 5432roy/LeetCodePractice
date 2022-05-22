package PalindromicSubstrings;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        
        for(int i = 0; i < s.length(); i++) {
            res += helper(i, i, s);
            res += helper(i, i + 1, s);
        }
        
        return res;
    }
    
    private int helper(int head, int tail, String s) {
        int count = 0;
        while(head >= 0 && tail < s.length() && (s.charAt(head) == s.charAt(tail))) {
            count++;
            head--;
            tail++;
        }
        return count;
    }
}
