package WeeklyContest261;

public class MinimumMovesToConvertString {
    public int minimumMoves(String s){
        int res = 0;

        boolean hasX = false;
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'X') hasX = true;
            count += hasX ? 1 : 0;
            if(count == 3){
                res++;
                count = 0;
                hasX = false;
            }

        }
        return res + (hasX ? 1 : 0);
    }
}
