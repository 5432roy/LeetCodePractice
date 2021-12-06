package LongestArithmeticSubsequenceOfGivenDifference;
import java.util.*;
public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args){
        HashMap<HashSet<Integer>, Integer> map = new HashMap<>();
        map.put(new HashSet<>(1,2), 0);
    }

    public int longestSubsequence(int[] arr, int difference){
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i - difference, 0) + 1);
            res = Math.max(res, map.get(i));
        }
        return res;
    }
    
}
