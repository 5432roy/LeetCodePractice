package LongestSubstringWithRepeating;

import java.util.HashMap;

public class LongestSubstringWithRepeating {

    public int lengthOfLongestSubstring(String s){
        int max = 0;
        for(int i = 0; i < s.length(); i++){

            int j = i;
            HashMap<Character, Integer> map = new HashMap<>();

            while(j < s.length() && !map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), 1);
                j++;
            }

            max = Math.max(max, j - i);
            if(max == s.length() - i) return max;
        }
        return max;
    }
}
