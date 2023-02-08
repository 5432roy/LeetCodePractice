package FindMinimumInRotatedSortedArrayII;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int head, int tail){
        while(head != tail && nums[head] == nums[tail]) head++;
        if(head == tail) return nums[head];

        int mid = head + (tail - head) / 2;

        if(nums[mid] < nums[head] || nums[mid] <= nums[tail]){
            return binarySearch(nums, head, mid);
        }
        else {
            return binarySearch(nums, mid + 1, tail);
        }
    }
    
}
