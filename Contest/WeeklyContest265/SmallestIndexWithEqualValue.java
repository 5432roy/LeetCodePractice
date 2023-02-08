package WeeklyContest265;

public class SmallestIndexWithEqualValue {

    public static void main(String[] args){
        int[] nums = {7,8,3,5,2,6,3,1,1,4,5,4,8,7,2,0,9,9,0,5,7,1,6};
        smallestEqual(nums);
    }

    public static int smallestEqual(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            System.out.println(i % n + " : " + nums[i]);
            if(i % 10 == nums[i]) return i;
        }
        return -1;
    }
    
}
