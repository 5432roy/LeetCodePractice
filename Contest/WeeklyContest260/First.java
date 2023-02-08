package WeeklyContest260;
import java.util.*;
public class First {

    public static void main(String[] args){
        int[] a = new int[10];
        int[] b = new int[10];

        a[0] = 100;
        b = a.clone();

        a[0] = 0;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public int maximumDifference(int[] nums) {
        int res = -1;
        int min = nums[0];
        for(int i : nums){
            min = Math.min(min, i);
            if(i > min) res = Math.max(res, i - min);
        }

        return res;
    }
}
