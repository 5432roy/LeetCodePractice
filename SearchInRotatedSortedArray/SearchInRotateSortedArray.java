package SearchInRotatedSortedArray;

public class SearchInRotateSortedArray {

    public int binarySearch(int[] nums, int target){

        int i = findRotatePoint(nums, 0, nums.length - 1);
        if(target <= nums[nums.length - 1]){
            return binarySearch(nums, i, nums.length - 1, target);
        }
        else if(target > nums[nums.length - 1]){
            return binarySearch(nums, 0, i - 1, target);
        }
        return -1;
    }

    private int binarySearch(int[] nums, int head, int end, int target){
        if(end >= head){
            int mid = head + (end - head) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] > target) return binarySearch(nums, head, mid - 1, target);
            return binarySearch(nums, mid + 1, end, target);

        }
        return -1;
    }

    private int findRotatePoint(int[] nums, int head, int end){
        if(head > end) return -1;

        int mid = head + (end - head) / 2;
    
        if(nums[head] > nums[mid]){
            return findRotatePoint(nums, head, mid);
        }
        if(nums[mid] > nums[end]){
            return findRotatePoint(nums, mid + 1, end);
        }
        return head;
    }
    
}
