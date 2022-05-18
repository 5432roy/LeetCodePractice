package BinaryShortestPath;
import java.util.*;;
public class BinaryShortestPath {

    public int solution(int[][] matrix) {
        int n = matrix.length - 1, res = 1;
        if(matrix[0][0] == 1 || matrix[n][n] == 1) return -1;
        int[] dir1 = new int[]{1,0,-1,0,1};
        int[] dir2 = new int[]{-1,-1,1,1,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                if(cur[0] == n && cur[1] == n) return res;
                for(int j = 0; j < 4; j++) {
                    if(helper(cur[0] + dir1[j], cur[1] + dir1[j + 1], n, matrix)) queue.offer(new int[]{cur[0] + dir1[j], cur[1] + dir1[j + 1]});
                    if(helper(cur[0] + dir2[j], cur[1] + dir2[j + 1], n, matrix)) queue.offer(new int[]{cur[0] + dir2[j], cur[1] + dir2[j + 1]});
                }
            }
            res++;
        }

        return res;
    }
    
    private boolean helper(int r, int c, int n, int[][] matrix) {
        return r >= 0 && r <= n && c >= 0 && c <= n && matrix[r][c] == 0;
    }
}
