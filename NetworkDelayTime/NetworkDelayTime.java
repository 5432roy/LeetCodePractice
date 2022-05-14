package NetworkDelayTime;

import java.util.*;

public class NetworkDelayTime {

        public int networkDelayTime(int[][] times, int n, int k) {
            int[][] cost = new int[n][n];
            
            for(int[] i : cost) {
                Arrays.fill(i, -1);
            }
            
            for(int[] i : times) {
                cost[i[0] - 1][i[1] - 1] = i[2];
            }
            
            int[] res = new int[n];
            Arrays.fill(res, Integer.MAX_VALUE);
            res[k - 1] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(k - 1);
            
            while(!queue.isEmpty()) {
                for(int t = queue.size(); t > 0; t--) {
                    int cur = queue.poll();
                    for(int i = 0; i < n; i++) {
                        if(i == cur || cost[cur][i] < 0) continue;
                        if(cost[cur][i] + res[cur] < res[i]) {
                            queue.offer(i);
                            res[i] = cost[cur][i] + res[cur];
                        }
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            
            for(int i : res) {
                if(i == Integer.MAX_VALUE) return -1;
                max = Math.max(i, max);
            }
            
            return max;
        }
    
}
