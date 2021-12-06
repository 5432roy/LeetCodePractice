package QueensThatCanAttacktheKing;
import java.util.*;
public class Queens {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king){
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, int[]> map = new HashMap<>();

        int id = 0;
        for(int[] queen : queens) map.put(id++, queen);

        int[] direction = {1,0,-1,0,1,-1,-1,1,1};
        for(int i = 0; i < direction.length - 1; i++){
            int[] position = {king[0], king[1]};
            boolean find = false;
            while(!(position[0] < 0 || position[0] >= 8 || position[1] < 0 || position[1] >= 8 || find)){
                for(int j = 0; j < map.size(); j++){
                    if(map.get(j)[0] == position[0] && map.get(j)[1] == position[1]){
                        find = true;
                        res.add(Arrays.asList(position[0], position[1]));
                        break;
                    }
                }
                position[0] += direction[i];
                position[1] += direction[i + 1];
            }
        }

        return res;
    }
    
}
