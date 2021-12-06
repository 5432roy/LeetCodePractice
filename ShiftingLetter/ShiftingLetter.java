package ShiftingLetter;
public class ShiftingLetter {

    public String shiftingLetters(String str, int[] nums){
        StringBuilder builder = new StringBuilder();
        int sum = 0;

        for(int i = str.length() - 1; i >= 0; i--){
            sum = (sum + nums[i]) % 26;
            builder.append((char)((str.charAt(i) + sum) > 122 ? str.charAt(i) + sum - 26 : str.charAt(i) + sum));
        }

        return builder.toString();
    }
    
}
