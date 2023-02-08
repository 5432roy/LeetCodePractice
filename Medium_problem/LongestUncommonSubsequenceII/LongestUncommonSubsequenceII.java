package LongestUncommonSubsequenceII;

import java.util.*;

public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs){
        int res = -1;
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return  b.length() - a.length();
            }
        });
        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() <= res) break;
            boolean sub = false;
            for(int j = 0; j < strs.length; j++){
                if(strs[i].length() > strs[j].length()) break;
                if(i == j) continue;
                sub = sub || isSub(strs[i], strs[j]);
            }
            res = sub ? res : strs[i].length();
        }
        return res;
    }

    public boolean isSub(String a, String b){
        int first = 0, second = 0;
        while(first < a.length() && second < b.length()){
            if(a.charAt(first) == b.charAt(second)) first++;
            second++;
        }

        return first == a.length();
    }
    
}
