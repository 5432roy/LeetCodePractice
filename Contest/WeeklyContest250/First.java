package WeeklyContest250;

import java.util.*;

public class First {
    
    public static void main(String[] args){
        String text = "abc agc adsfa afwae";
        canBeTypedWords(text,"a");
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ",0);
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < brokenLetters.length(); i++){
            queue.add(brokenLetters.charAt(i));
        }
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            boolean valid = true;
            for(int j = 0; j < arr[i].length(); j++){
                if(queue.contains(arr[i].charAt(j))){
                    valid = false;
                    break;
                }
            }
            if(valid) count++;
        }
        return count;
    }
}
