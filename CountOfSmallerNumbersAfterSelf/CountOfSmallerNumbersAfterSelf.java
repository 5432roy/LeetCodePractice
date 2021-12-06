package CountOfSmallerNumbersAfterSelf;

import java.util.List;
import java.util.ArrayList;
// not finished
// merge sorted required 
public class CountOfSmallerNumbersAfterSelf{
    public static void main(String[] args){
        int[] nums = {5,2,6,1};
        int[] case1 = {-1,-1,-1};
        int[] case2 = {1,2,7,8,5};
        int[] case3 = {0,1,2};
        int[] case4 = {6035,5253,-214,-4704,-6521,570,6603,2074,-4186,-441,-1870,-4763};
        countSmaller(nums);
        countSmaller(case1);
        countSmaller(case2);
        countSmaller(case3);
        countSmaller(case4);
    }
    public static int countSmaller2(int nums[]){
        

        return 0;
    }

    // brute force O(n^2)
    public static void countSmaller(int[] nums){
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        int[] numbers = new int[2*10000+1];
        int length = nums.length, max = nums[length-1], min = nums[length-1];
        for(int i = length - 2; i >= 0; i--){
            int notSmaller = 0;
            if(min > nums[i] && i > 0){
                min = Math.min(nums[i-1],nums[i]);
                ans.add(0,0);
                i--;
            }
            if(max < nums[i] && i > 0){
                max = Math.max(nums[i-1], nums[i]);
                ans.add(0, length - 1 - i);
                i--;
            }
            for(int j = i + 1; j < length; j++){
                if(nums[i] < nums[j]) notSmaller++;
                if(nums[i] == nums[j]) {
                     notSmaller = notSmaller + numbers[nums[i]+10000] + 1;
                     j = length;
                }
            }
            numbers[nums[i]+10000] = notSmaller;
            ans.add(0, length - 1 - i - notSmaller);
        }
        System.out.println(ans);
    }
}