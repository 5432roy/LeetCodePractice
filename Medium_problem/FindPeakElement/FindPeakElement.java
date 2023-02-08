package FindPeakElement;

public class FindPeakElement {

    public static void main(String[] args){
        int[] test = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(test));
    }

    public static int findPeakElement(int[] nums){
        int head = 0, end = nums.length - 1; 

        while(end > head){
            int mid = (head + end) / 2;
            int mid2 = mid + 1;

            if(nums[mid2] > nums[mid]){
                head = mid2;
            }
            else{
                end = mid;
            }
        }
        return head;
    }
    
}
