/*
 * 2685. Count the Number of Complete Components
 * https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2025-03-22
 * 
 * Union find question
 * A graph is a complete connected graph if and only if the edge counts for each vertex is the same and equal to the parents count;
 * 
 * Time Complexity: O((E + V) * logV), where E is the count of edges and V is the count of vertices.
 */

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        UF uf = new UF(n);

        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count();
    }
}

class UF {
    int[] parents;
    int[] rank;
    int[] adj;
    public UF(int n) {
        parents = new int[n];
        rank = new int[n];
        adj = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        Arrays.fill(rank, 0);
    }

    private int find(int i) {
        if(parents[i] != i) {
            return find(parents[i]);
        }
        return i;
    }

    public void union(int i, int j) {
        int ip = find(i), jp = find(j);
        if(rank[ip] >= rank[jp]) {
            parents[jp] = ip;
            rank[ip]++;
        } else {
            parents[ip] = jp;
            rank[jp]++;
        }
        adj[i]++;
        adj[j]++;
    }

    public int count() {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int res = 0;

        for(int i = 0; i < parents.length; i++) {
            int cur = find(i);
            if(!map.containsKey(cur)) {
                map.put(cur, new ArrayList<Integer>());
            }
            map.get(cur).add(i);
        }

        for(int key : map.keySet()) {
            boolean cur = true;
            for(int i : map.get(key)) {
                if(adj[i] + 1 != map.get(key).size()) {
                    cur = false;
                    break;
                }
            }
            res += cur ? 1 : 0;
        }

        return res;
    }
}