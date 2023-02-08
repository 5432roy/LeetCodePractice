package WeeklyContest249;

public class First {

    public static void main(String[] args){

    }

    public static int[] get(int nums[]){
        int[] ans = new int[nums.length * 2];

        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
    
}
