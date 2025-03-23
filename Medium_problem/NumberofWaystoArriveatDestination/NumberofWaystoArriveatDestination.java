package Medium_problem.NumberofWaystoArriveatDestination;
/*
 * 1976. Number of Ways to Arrive at Destination
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/?envType=daily-question&envId=2025-03-23
 * 
 * Dijkstra Question
 * Edge Case: Sum of distance can also overflow int. Used long[] instead
 * 
 * Time Complexity: O((V + E) log V)
 */
class Solution {
    public int countPaths(int n, int[][] roads) {
        if(n == 1) {
            return 1;
        }
        HashMap<Integer, HashMap<Integer, Integer>> edges = new HashMap<>();

        for(int[] road : roads) {
            if(!edges.containsKey(road[0])) {
                edges.put(road[0], new HashMap<>());
            }
            if(!edges.containsKey(road[1])) {
                edges.put(road[1], new HashMap<>());
            }

            edges.get(road[0]).put(road[1], road[2]);
            edges.get(road[1]).put(road[0], road[2]);
        }

        return dijkstra(edges, n);
    }

    private int dijkstra(HashMap<Integer, HashMap<Integer, Integer>> edges, int n) {
        long[] dist = new long[n];
        long[] count = new long[n];
        int mod = 1000000007;
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        count[0] = 1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.add(new long[]{0, 0});

        while(!q.isEmpty()) {
            long[] cur = q.poll();
            int u = (int) cur[0];
            long ud = cur[1];

            if(dist[u] < ud) {
                continue;
            }

            for(int v : edges.get(u).keySet()) {
                int vd = edges.get(u).get(v);
                if(dist[v] > ud + vd) {
                    dist[v] = ud + vd;
                    count[v] = count[u];
                    q.add(new long[]{v, dist[v]});
                } else if(dist[v] == ud + vd){
                    count[v] = (count[v] + count[u]) % mod;
                }
            }
        }

        return (int) count[n - 1];
    }

}