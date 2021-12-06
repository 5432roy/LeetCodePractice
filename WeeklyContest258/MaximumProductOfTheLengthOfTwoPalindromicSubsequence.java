package WeeklyContest258;
import java.util.*;
public class MaximumProductOfTheLengthOfTwoPalindromicSubsequence {

    public static void main(String[] args){
        StringBuilder builder = new StringBuilder();
        builder.append("abc");

        System.out.println(builder.toString().equals(builder.reverse().toString()));
        for(int i = 0; i < 5; i++){
            System.out.println(i + ": " + ((31 >> i) & 1));
        }

        System.out.println(3 >> 1);
    }

    public int maxProduct(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 1; i < 1 << s.length(); i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                if((i >> j & 1) == 1) builder.append(s.charAt(j));
            }
            if(builder.toString().equals(builder.reverse().toString())) map.put(i, builder.length());
        }
        int res = 1;
        for(int i : map.keySet()){
            for(int j : map.keySet()){
                res = Math.max(res, i == j ? 0 : ((i & j) == 0 ? map.get(i) * map.get(j) : 0));
            }
        }
        return res;
    }
}
