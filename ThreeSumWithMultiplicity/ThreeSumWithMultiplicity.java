package ThreeSumWithMultiplicity;
import java.util.*;
public class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] arr, int target) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        long res = 0;
        int mod = 1000000007;
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : map.keySet()){
            res += helper(i, target - i, mod, map);
            res %= mod; 
        }
        return (int)res;
    }

    private int helper(int i, int target, int mod, TreeMap<Integer,Integer> map){
        long res = 0;
        int first = i, last = map.lastKey();
        while(first <= last){
            int cur = first + last;
            if(cur > target){
                if(map.lowerKey(last) == null) break;
                last = map.lowerKey(last);
            }
            else if(cur == target){
                if(first == i){
                    if(first == last) res += map.get(i) * (map.get(i) - 1) * (map.get(i) - 2) / 6 % mod;
                    else res += map.get(i) * (map.get(i) - 1) * map.get(last) / 2 % mod;
                }
                else if(last == first){
                    res += map.get(i) * map.get(first) * (map.get(last) - 1) / 2 % mod;
                }
                else res += map.get(i) * map.get(first) * map.get(last) % mod;
                res %= mod;
                if(map.higherKey(first) == null) break;
                first = map.higherKey(first);
            }
            else if(cur < target){
                if(map.higherKey(first) == null) break;
                first = map.higherKey(first);
            }
        }

        return (int)res;
    }
}
