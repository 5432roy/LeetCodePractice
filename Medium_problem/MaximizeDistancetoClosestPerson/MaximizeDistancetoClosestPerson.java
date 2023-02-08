package MaximizeDistancetoClosestPerson;

public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, res = 0;
        
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                res = prev == -1 ? i : Math.max(res, (i - prev) / 2);
                prev = i;
            }
        }
        if(seats[seats.length - 1] == 0){
            res = Math.max(res, (seats.length - 1 - prev));
        }
        return res;
    }
}
