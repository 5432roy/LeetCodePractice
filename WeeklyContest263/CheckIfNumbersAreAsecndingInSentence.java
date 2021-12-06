package WeeklyContest263;
import java.util.*;
public class CheckIfNumbersAreAsecndingInSentence {
    
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int prev = Integer.MIN_VALUE;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(Integer.toString(i).charAt(0));
        }
        for(String str : strs){
            if(list.contains(str.charAt(0))){
                if(prev >= Integer.parseInt(str)){
                    return false;
                }
                prev = Integer.parseInt(str);
            }
        }

        return true;
    } 
}
