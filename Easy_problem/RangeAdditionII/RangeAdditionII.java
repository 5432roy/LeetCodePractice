package RangeAdditionII;

import java.util.PriorityQueue;

public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops){
        PriorityQueue<Integer> row = new PriorityQueue<>();
        PriorityQueue<Integer> col = new PriorityQueue<>();
        //int res = 0;
        
        for(int i = 0; i < ops.length; i++){
            row.add(ops[i][0]);
            col.add(ops[i][1]);
        }

        if(row.size() == 0 && col.size() == 0) return m * n;

        return row.size() == 0 ? 1 : row.peek() * col.size() == 0 ? 1 : col.peek();
    }
    
}
