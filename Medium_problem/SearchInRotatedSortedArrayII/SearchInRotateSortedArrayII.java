package SearchInRotatedSortedArrayII;

public class SearchInRotateSortedArrayII {
    public boolean search(int[] nums, int target) {
        int rotatePoint = rotatePoint(nums);
        System.out.println(rotatePoint);
        int head = (target > nums[nums.length - 1]) ? 0 : rotatePoint,
        tail = target > nums[nums.length - 1] ? rotatePoint : nums.length - 1;
        while(tail >= head){
            int mid = head + (tail - head) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > target) tail = mid - 1;
            if(nums[mid] < target) head = mid + 1;
        }
        
        return false;
    }
    
    public int rotatePoint(int[] nums){
        int point = 1;
        while(point < nums.length && nums[point - 1] <= nums[point]) point++;
        return point == nums.length ? 0 : point;
    }
    
}
