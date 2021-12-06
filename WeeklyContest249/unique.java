package WeeklyContest249;

import java.util.*;

public class unique {

    public static void main(String[] args){
        String s = "bbcbaba";

        System.out.println(count(s));

    }

    public static int count(String s){

        Queue<Character> queue = new LinkedList<>();
        int sum = 0;
        for(int i = 0 ; i < s.length() - 2; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            int left = i;
            int right = s.length() - 1;
            if(queue.isEmpty() || !queue.contains(s.charAt(left))){
                queue.add(s.charAt(left));
                while(right != left && s.charAt(right) != s.charAt(left)){
                    right--;
                }
                while(right - left >= 2){
                    right--;
                    map.put(s.charAt(right), 1);
                }
                sum += map.size();
            }
        }
        return sum;
    }
    
}
