package WeeklyContest251;
public class Second {


    public static String maximumNumber(String num, int[] change) {

        char[] nums = num.toCharArray();
        boolean start = false;
        for(int i = 0; i < num.length(); i++){
            if(nums[i] < change[nums[i] - '0']){
                start = true;
                nums[i] = (char)(change[nums[i] - '0'] + 48);
            } else if(nums[i] > change[nums[i] - '0']&& start) {
                break;
                }
        }

        StringBuilder sb = new StringBuilder();
        for(char cur : nums){
            sb.append(cur);
        }
        return sb.toString();
    }
    
}
