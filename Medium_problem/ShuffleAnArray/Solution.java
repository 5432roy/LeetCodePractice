package ShuffleAnArray;

import java.util.*;

public class Solution {

    private int nums[];
    private Random random;

    public Solution(int[] nums){
        this.nums = nums;
        random = new Random();
    }

    public int[] reset(){
        return nums;
    }

    public int[] shuffle(){
        if(nums == null) return null;

        int[] shuffled = nums.clone();

        for(int i = 0; i< nums.length; i++){
            int swap = random.nextInt(i + 1);
            swap(shuffled, i, swap);
        }

        return shuffled;
    }

    private void swap(int[] input, int origin, int randomPosition){
        int temp = input[origin];
        input[origin] = input[randomPosition];
        input[randomPosition] = temp;
    }
    
}
