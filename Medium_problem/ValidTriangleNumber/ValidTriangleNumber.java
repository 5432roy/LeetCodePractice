package ValidTriangleNumber;

import java.util.*;

public class ValidTriangleNumber {

    public static void main(String[] args){

    }
    // can implement binary search for finding index k, which satisfied the condintion that a + b > c
    public static int triangleNumber(int[] nums){
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int k = nums.length - 1;
                while(k > j && nums[i] + nums[j] <= nums[k]){
                    k--;
                }
                sum += k - j;
            }
        }

        return sum;
    }
    
    public static int triangleNumberOptimized(int[] nums){
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int k = nums.length - 1;
                while(k > j && nums[i] + nums[j] <= nums[k]){
                    k--;
                }
                sum += k - j;
            }
        }

        return sum;
    }
}
