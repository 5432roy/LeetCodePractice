package CheapestFilghtsWithinKStops;
import java.util.*;
public class CheapestFlightsWithinKStop {

    public int findCheapesetPrice(int n, int[][] flights, int src, int dst, int k){
        int[][] adjacency = new int[n][n];
        for(int[] flight : flights){
            adjacency[flight[0]][flight[1]] = flight[2];
        }

        int[] distance = new int[n];
        int[] stops = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        distance[src] = 0;
        stops[src] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        heap.offer(new int[]{src, 0, 0});

        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            
            if(cur[0] == dst) return cur[1];

            if(cur[2] > k) continue;

            for(int adj = 0; adj < n; adj++){
                if(adjacency[cur[0]][adj] > 0){
                    int newCost = cur[2] + adjacency[cur[0]][adj];
                    if(newCost < distance[cur[adj]]){
                        heap.offer(new int[]{adj, newCost, cur[2] + 1});
                        distance[adj] = newCost;
                    }
                    else if(cur[2] < stops[adj]){
                        heap.offer(new int[]{adj, newCost, });
                    }
                }
            }
        }

        return -1;
    }

    
}
