package JumpGame;

public class JumpGame {

    public boolean canJump(int[] nums){
        int max = 0 ;
        int index = 0;
        while(index <= max){
            max = Math.max(max, index + nums[index]);
            index++;
            if(max >= nums.length - 1) return true;
        }
        return false;
    }
    
}
