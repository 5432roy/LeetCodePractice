package DetermineIfStringHalvesAreAlike;

import java.util.Queue;
import java.util.LinkedList;

public class DetermineIfStringHalvesAreAlike {

    public static void main(String[] args){
        String a = "";
        String s = "bOok";
        a = a + s.charAt(0);
        System.out.println(a);
        System.out.println(halvesAreAlike(s));
    }
    
    public static boolean halvesAreAlike(String s){
        int left = 0, right = 0, mid = s.length()/2;
        Queue<Character> queue = new LinkedList<>();

        s = s.toLowerCase();
        queue.add('a');
        queue.add('e');
        queue.add('i');
        queue.add('o');
        queue.add('u');
        for(int i = 0; i < mid; i++){
            if(queue.contains(s.charAt(i))) left++;
        }
        for(int i = mid; i < s.length(); i++){
            if(queue.contains(s.charAt(i))) right++;
        }
        return left == right;
    }
}
