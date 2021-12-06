package WeeklyContest261;

public class FindMissingObservation {
    public int[] missingRolls(int[] rolls, int mean, int n){
        int[] res = new int[n];
        int sum = mean * (rolls.length + n);

        for(int i : rolls){
            sum -= i;
        }

        int i = sum / n;
        int mod = sum % n;
        
        if(i > 6 || i < 1) return new int[]{};

        for(int index = 0; index < res.length; index++){
            res[index] = i + (mod-- > 0 ? 1 : 0);
        }

        return res;
    }
    
}
