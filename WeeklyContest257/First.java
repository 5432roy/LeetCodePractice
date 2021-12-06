package WeeklyContest257;
import java.util.*;
public class First {

    public static void main(String[] args){
        int a;
        System.out.println((int)'z');
        int[] test = {1,1,1,3,5};
        countQuadruplets(test);
    }

    public static int countQuadruplets(int[] nums){
        int res = 0;

        for(int i = 3; i < nums.length;i++){
            Arrays.sort(nums, 0, i);
            for(int j = i - 1; j > 1; j--){
                res += twoSum(nums, nums[i] - nums[j], j);
            }
        }
        return res;
    }

    public static int twoSum(int[] nums, int target, int tail){
        int count = 0;
        int front = 0, end = tail - 1;
        while(end > front){
            if(nums[front] + nums[end] > target) end--;
            else if(nums[front] + nums[end] < target) front++;
                else {
                    System.out.println(front + "," + end + "," + tail);
                    if(nums[end] == nums[end -1]) end--;
                    else{
                        front++;
                    }   
                        count++;
                    }
        }

        return count;
    }
    
}
