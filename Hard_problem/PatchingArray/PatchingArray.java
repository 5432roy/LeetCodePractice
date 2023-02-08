package PatchingArray;
//Review required
public class PatchingArray {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};
        System.out.println(minPatches(nums, 10));
    }

    public static int minPatches(int[] nums, int n){
        long currentMax = 0;
        int patch = 0, i = 0;
        while(currentMax < n){
            if(i < nums.length && nums[i] <= currentMax + 1){
                currentMax += nums[i];
                i++;
            }
            else{
                currentMax = currentMax * 2 + 1;
                patch++;
            }
        }

        return patch;
    }
    
}
