package WeeklyContest252;

public class First {

    public boolean isThree(int n){
        int count = 1;
        for(int i = 2; i <= n; i++){
            if(n % i == 0) count++;
            if(count > 3) return false;
        }
        return count == 3;
    }
    
}
