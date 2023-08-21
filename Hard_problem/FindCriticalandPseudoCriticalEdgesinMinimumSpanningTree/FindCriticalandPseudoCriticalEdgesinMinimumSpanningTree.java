package FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree;

/*
 * 1489. Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree 
 * Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the minimum possible total edge weight.
 * Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other hand, a pseudo-critical edge is that which can appear in some MSTs but not all.
 * Note that you can return the indices of the edges in any order.
 */


// Solution From @luo122174088 

class UnionFind {
    final int[] parents;
    int count;

    // set are parents to itself
    public UnionFind(int n) {
        this.parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        this.count = n;
    }

    // find the source of i
    public int find(int i) {
        int parent = parents[i];
        
        if(parent == i) {
            return i;
        } else {
            parents[i] = find(parent);
            return parents[i];
        }
    }


    // return True if i and j are not connected yet
    public boolean union(int i, int j) {
        int r1 = find(i), r2 = find(j);
        if(r1 == r2) {
            return false;
        } else {
            this.count--;
            parents[r1] = r2;
            return true;
        }
    }
}

class FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        // keep track of the index to return after sorted
        Map<int[], Integer> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            map.put(edges[i], i);
        }

        // sort the array so that we can build the MST easily
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));

        int minCost = buildMST(n, edges, null, null);

        for(int i = 0; i < edges.length; i++) {
            int index = map.get(edges[i]);
            int costWithout = buildMST(n, edges, null, edges[i]);
            
            // if the cost became larger, than this edge is critical
            if(costWithout > minCost) {
                critical.add(index);
            } else {
                // if the cost doesn't matter with or without this edge, it is not pseudo either
                int costWith = buildMST(n, edges, edges[i], null);
                if(costWith == minCost) {
                    pseudo.add(index);
                }
            }
        }

        return Arrays.asList(critical, pseudo);
    }

    private int buildMST(int n, int[][] edges, int[] pick, int[] skip) {
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        
        // add the edge that we require
        if(pick != null) {
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }

        // finish the MST
        for(int[] edge : edges) {
            if(edge != skip && uf.union(edge[0], edge[1])) {
                cost += edge[2];
            }
        }

        return uf.count == 1 ? cost : Integer.MAX_VALUE;
    }
}