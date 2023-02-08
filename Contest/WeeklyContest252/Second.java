package WeeklyContest252;
import java.util.*;
public class Second {

    public static void main(String[] args){
        int[] test = {5,2,1};
        numberOfWeeks(test);
    }

    public static long numberOfWeeks(int[] milestones) {
        if(milestones.length == 1) return 1;
        
        Arrays.sort(milestones);
        int length = milestones.length;
        int[] memo = new int[length];
        memo[0] = milestones[0];
        for(int i = 1; i < length; i++) memo[i] = memo[i - 1] + milestones[i];
        return memo[length - 2] + 1 > milestones[length - 1] ? memo[length - 1] : memo[length - 2] * 2 + 1;
    }
}
