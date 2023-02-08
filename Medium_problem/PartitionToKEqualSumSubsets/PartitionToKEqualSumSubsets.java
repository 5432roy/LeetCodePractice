package PartitionToKEqualSumSubsets;
import java.util.*;
public class PartitionToKEqualSumSubsets {
    
    public boolean canPartitionKSubsets(int[] nums,  int k){
        int sum = 0;

        for(int i : nums) sum += i;

        if(sum % k == 0){

            for(int i = 0; i < nums.length; i++){
                int bit = 0;
                while(i > 0){
                    

                    bit++;
                }
            }
        }

        return false;
    }
}
