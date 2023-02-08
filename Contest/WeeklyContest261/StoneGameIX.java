package WeeklyContest261;

public class StoneGameIX {

    public boolean stoneGameIX(int[] stones){
        int[] count = new int[3];

        for(int stone : stones){
            count[stone % 3]++;
        }

        if(count[0] != 0 && count[1] != 0 && count[2] % 2 == 0) return true;

        return false;
    }
    
}
