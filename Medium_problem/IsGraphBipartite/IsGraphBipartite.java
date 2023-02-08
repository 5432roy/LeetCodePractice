package IsGraphBipartite;
import java.util.*;
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        // since the graph may be disconnected
        // we need to check if we have visited every group
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(visited[i]) continue;
            // if this is a new group test if this group can be divied into two
            int[] nodes = new int[graph.length];
            Queue<Integer> queue = new LinkedList<>();
            nodes[i] = -1;
            queue.offer(i);
            
            while(!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            int[] neighbors = graph[cur];
            
                for(int neighbor : neighbors) {
                    // if there is a collision, this group can not form a bipartite graph
                    if(nodes[neighbor] == nodes[cur]) return false;
                    if(nodes[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                    nodes[neighbor] = nodes[cur] == 1 ? -1 : 1;
                }
            }
        }
        return true;
    }
}
