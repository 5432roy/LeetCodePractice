package BiweeklyContest60;
import java.util.*;
public class Second {

    public int[][] findFarmLand(int[][] land){
        Queue<int[]> queue = new LinkedList<>();
        int m = land.length, n = land[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1)
                queue.add(new int[]{i,j});
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int i = queue.peek()[0], j = queue.poll()[1];
            if(land[i][j] == 1){
                List<Integer> farm = new ArrayList<>(Arrays.asList(i, j, i + a(land, i, j) - 1, j + b(land, i, j + 1)));
                list.add(farm);
                visited(land, i, j);
            }
        }

        int[][] res = new int[list.size()][4];
        for(int index = 0; index < list.size(); index++){
            List<Integer> temp = new ArrayList<>(list.get(index));
            for(int cor = 0; cor < temp.size(); cor++){
                res[index][cor] = temp.get(cor);
            }
        }
        return res;
    }

    public void visited(int[][] land, int i, int j){
        if(i >= land.length || j >= land[0].length || land[i][j] != 1) return;
        land[i][j] = -1;
        visited(land, i + 1, j);
        visited(land, i, j + 1);
    }

    public int a(int[][] land, int i, int j){
        if(i >= land.length || j >= land[0].length || land[i][j] != 1) return 0;
        return 1 + a(land, i + 1, j);
    }

    public int b(int[][] land, int i, int j){
        if(i >= land.length || j >= land[0].length || land[i][j] != 1) return 0;
        return 1 + b(land, i, j + 1);
    }

    
}
