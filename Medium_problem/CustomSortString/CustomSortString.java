package CustomSortString;

import java.util.*;

public class CustomSortString {

    public static void main(String[] args){
        customSortString("abc", "acababbaadd");
    }

    public static String customSortString(String order, String str){
        String ans = "";

        int[] toInt = new int[26];
        for(int i = 0; i < str.length(); i++){
            toInt[str.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(toInt));

        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            for(int j = 0; j < toInt[ch - 'a']; j++){
                ans += ch; 
            }
            toInt[ch - 'a'] = 0;
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            while(toInt[ch - 'a'] != 0){
                ans += ch;
                toInt[ch - 'a']--;
            }
        }

        System.out.println(ans);
        return order;
    }
    
}
