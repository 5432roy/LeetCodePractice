package MaxConsecutiveOnesIII;

import java.util.Queue;
import java.util.LinkedList;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args){
        int[] case1 = {1,0,0,0,1,1,1,1,0};
        int[] case2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        longestOnes(case1, 2); // 6
        longestOnes(case2, 3); // 10
        implementQueue(case1, 2);
        implementQueue(case2, 3);
    }
    //Sliding Window, the size of window is not fixed
    //4ms runtime
    public static void longestOnes(int[] nums, int k){
        int max = k, size = 0, zeros = 0, head = 0;
        boolean isHeadZero = nums[head] == 0;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] == 0 && zeros == k && !isHeadZero){
                head++;
                isHeadZero = nums[head] == 0;
                size--;
            }
            if(nums[i] == 0 && zeros == k && isHeadZero){
                head++;
            }
            if(nums[i] == 0 && zeros < k){ 
                zeros++;
                size++;
            }
            if(nums[i] == 1) size++;
            if(head < nums.length) isHeadZero = nums[head] == 0;
            max = Math.max(max, size);
        }
        //return
        System.out.println(max);
    }
    //8ms runtime
    public static void implementQueue(int[] nums, int k){
        Queue<Integer> queue = new LinkedList<>();
        int zeros = 0, size = 0;
        for(int i : nums){
            queue.add(i);
            if(i == 0){
                zeros++;
            }
            while(zeros > k){
                if(queue.poll() == 0) zeros--;
            }
            size = Math.max(queue.size(), size);
        }
        System.out.println(size);
    }
    // 2ms runtime
    public int Sample(int[] nums, int k) {
        int start = 0;
        int end;
        for (end = 0 ; end < nums.length ; end++) {
            if (nums[end] == 0) k--;
            if (k<0) {
                if (nums[start] == 0) k++;
                start++;
            }
        }
        return end - start;   
    }
}
