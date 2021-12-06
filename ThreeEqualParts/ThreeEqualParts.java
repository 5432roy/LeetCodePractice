package ThreeEqualParts;
import java.util.*;
public class ThreeEqualParts {

    public static void main(String[] args){
        int[] nums = {1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0};


        System.out.println(Arrays.toString(threeEqualParts(nums)));
    }

    public static int[] threeEqualParts(int[] nums){
        int numOne = 0;
		for (int i : nums){
			if (i == 1) numOne++;
		}
        
        int[] ans = {-1, -1};
        if (numOne == 0) return new int[]{0,2};
        if (numOne % 3 != 0) return ans;
        
        //find index of starting 1 of third string
        int third = 0;
		int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] == 1){
                temp++;
                if (temp == numOne / 3){
                    third = i;
                    break;
                }
            } 
        }
        
        int res1 = valid(nums, 0, third);
        if (res1<0) return ans;
        
        int res2 = valid(nums, res1+1, third);
        if (res2<0) return ans;
        
        return new int[]{res1, res2+1};
    }
    
    private static int valid(int[] nums, int left, int right){
        while (nums[left]==0) left++;
        while (right < nums.length){
            if (nums[left]!=nums[right]) return -1;
            left++;
            right++;            
        }
        return left-1;
    }


    
}
