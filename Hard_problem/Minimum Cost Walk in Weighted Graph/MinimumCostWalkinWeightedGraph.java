// 3108. Minimum Cost Walk in Weighted Graph
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UF uf = new UF(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }

        int[] res = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            res[i] = uf.minCost(query[i][0], query[i][1]);
        }

        return res;
    }
}
// Union Find Class
class UF {
    int[] parents;
    int[] minWeight;

    public UF (int n) {
        parents = new int[n];
        minWeight = new int[n];
        // -1 in bitwise is all 1, so will not lose any value while doing bitwise &
        Arrays.fill(minWeight, -1);
        
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    private int find(int n) {
        if(n != parents[n]) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }

    public void union(int a, int b, int weight) {
        int ap = find(a), bp = find(b);
        minWeight[ap] = minWeight[bp] = minWeight[ap] & minWeight[bp] & weight;
        parents[bp] = ap;
    }

    public int minCost(int a, int b) {
        if(find(a) != find(b)) {
            return -1;
        }
        return minWeight[find(a)];
    }
}