package LargestMultipleOfThree;
public class LargestMultipleOfThree {

    public String largestMultipleOfThree(int[] nums) {
        int[] mod1 = {1, 4, 7, 2, 5, 8}, mod2 = {2, 5, 8, 1, 4, 7}, count = new int[10];
        int sum = 0;

        for(int cur : nums){
            count[cur]++;
            sum += cur;
        }
        
        if(sum == 0) return "0";

        while(sum % 3 != 0){
            for(int num : sum % 3 == 1 ? mod1 : mod2){
                if(count[num] > 0){
                    sum -= num;
                    count[num]--;
                    break;
                }
            }
        }
        StringBuilder builder = new StringBuilder();

        for(int i = 9; i >= 0; i--){
            while(count[i] > 0){
                builder.append(i);
                count[i]--;
            }
        }

        return builder.toString();
    }

    
}
