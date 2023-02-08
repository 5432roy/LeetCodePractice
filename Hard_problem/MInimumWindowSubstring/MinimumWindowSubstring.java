package MInimumWindowSubstring;
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] memo = new int[128];
        for(char ch : t.toCharArray()){
            memo[ch]++;
        }
        int start = 0, end = 0, minStart = 0, min = Integer.MAX_VALUE, valid = t.length();
        while(end < s.length()){
            final char runner = s.charAt(end);
            if(memo[runner]-- > 0) valid--;
            end++;
            while(valid == 0){
                if(min > end - start){
                    min = end - start;
                    minStart = start;
                }
                final char head = s.charAt(start);
                memo[head]++;
                if(memo[head] > 0) valid++;
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);   
    }
    
}
