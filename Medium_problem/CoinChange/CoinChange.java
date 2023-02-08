package CoinChange;
import java.util.*;
public class CoinChange {

    public int coinChange(int[] coins, int amount){
        if(amount == 0) return 0;
        int[] memo = new int[amount];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        int res = 0;
        while(!queue.isEmpty()){
            res++;
            for(int i = queue.size(); i > 0; i--){
                int cur = queue.poll();
                for(int coin : coins){
                    int next = cur - coin;
                    if(next > 0 && memo[next] == 0){
                        memo[next] = 1;
                        queue.offer(next);
                    }
                    if(next == 0){
                        return res;
                    }
                }
            }
        }

        return -1;
    }
    
}
