package GasStation;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int station[] = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            station[i] = gas[i] - cost[i];
        }
        
        int prev = 0;
        for(int i = 0; i < station.length; i++){
            if(station[i] < 0){
                prev += station[i];
            }
            else{
                int rest = 0, temp = i;
                while(temp < station.length && rest + station[temp] > 0 || (temp == station.length - 1 && rest >= 0)){
                    rest += station[temp];
                    temp++;
                }
                if(rest + prev >= 0 && temp == station.length) return i;
                else prev += station[i];
            }

        }

        return -1;
         
    }
    
}
