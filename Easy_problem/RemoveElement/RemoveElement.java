package RemoveElement;

import java.util.*;

public class RemoveElement {

    public static void main(String[] args){

    }

    public static int removeElement(int[] nums, int val){
        int length = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] ==  val){
                nums[i] = 101;
                length--;        
            }
        }
        Arrays.sort(nums);
        return length;
    }
    
}
