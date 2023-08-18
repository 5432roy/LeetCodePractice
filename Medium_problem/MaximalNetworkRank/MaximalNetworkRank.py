class Solution:
    """
    1615. Maximal Network Rank

    There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

    The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

    The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

    Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
    """

    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        """
        simply graph problem, could have improve the time complexity by changing memo into a dictionary of set.
        Reduce the following code from O(n) to O(1) => if [sorted_memo[i][0], sorted_memo[j][0]] in roads or [sorted_memo[j][0], sorted_memo[i][0]] in roads 
        """
        memo = [[i,0] for i in range(n)]

        for road in roads:
            memo[road[0]][1] += 1
            memo[road[1]][1] += 1
        
        res = 0
        
        sorted_memo = sorted(memo, key=lambda x: x[1], reverse=True)

        maximum, second_max = sorted_memo[0][1], sorted_memo[1][1]
        res = 0

        for i in range(n - 1):
            if sorted_memo[i][1] < maximum:
                break

            j = i + 1
            while j < n and sorted_memo[j][1] >= second_max:
                if sorted_memo[i][1] + sorted_memo[j][1] < res:
                    break
                
                if [sorted_memo[i][0], sorted_memo[j][0]] in roads or [sorted_memo[j][0], sorted_memo[i][0]] in roads:
                    res = sorted_memo[i][1] + sorted_memo[j][1] - 1
                else:
                    res = sorted_memo[i][1] + sorted_memo[j][1]
                    return res

                j += 1


        return res
                    
        