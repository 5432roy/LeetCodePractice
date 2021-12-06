package WeeklyContest250;

public class Second {
    
    public static void main(String[] args){
        int[] nums = new int[]{1,100};
        System.out.println(addRungs(nums, 2));
    }

    public static int addRungs(int[] nums, int dist) {
        int start = 0, i = 0, count = 0;

        while(start < nums[nums.length - 1]){
            if(i < nums.length && (nums[i] - start) <= dist){
                start = nums[i];
                i++;
            }
            else{
                int a = (nums[i] - start - 1) / dist;
                start += a * dist;
                count += a;
            }
        }

        return count;
    }
}

