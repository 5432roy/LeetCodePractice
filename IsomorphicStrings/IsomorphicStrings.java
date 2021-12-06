package IsomorphicStrings;

import java.util.*;

public class IsomorphicStrings {

    public static void main(String[] args){
        String s1 = "adc";
        String s2 = "abc";
        System.out.println(isIsomorphic(s1, s2));

    }
    
    public static boolean isIsomorphic(String s1, String s2){
        HashMap<Character,Integer> map  = new HashMap<>();

        String pattern1 = ""; 
        for(int i = 0, num = 0; i < s1.length(); i++){
            if(!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), num);
                num++;
            }
            pattern1 += map.get(s1.charAt(i));
        }

        map.clear();

        String pattern2 = "";
        for(int i = 0, num = 0; i < s2.length(); i++){
            if(!map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i), num);
                num++;
            }
            pattern2 += map.get(s2.charAt(i)); 
        }

        return pattern1.equals(pattern2);
    }
}
