package Medium_problem.MinimumOperationstoMakeaUni-ValueGrid;
/*
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
 * 
 * Posted explaination and proof:
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/solutions/6580004/easy-java-solution-with-explainaton-and-brief-proof/?envType=daily-question&envId=2025-03-26
 */
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int base = grid[0][0] % x;
        List<Integer> list = new ArrayList<>();
        for(int[] row : grid) {
            for(int col : row) {
                if(col % x != base) {
                    return -1;
                }
                list.add(col);
            }
        }

        Collections.sort(list);

        int median = list.get(m * n / 2), res = 0;

        for(int i : list) {
            res += Math.abs(i - median) / x;
        }

        return res;
    }
}