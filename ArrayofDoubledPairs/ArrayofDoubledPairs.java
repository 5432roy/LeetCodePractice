package ArrayofDoubledPairs;
import java.util.*;
public class ArrayofDoubledPairs {

    public static void main(String[] args){
        int[] arr = {1,2,1,-8,8,-4,4,-4,2,-2};
        System.out.println(canReorderDoubled(arr));
        

    }
    public static boolean canReorderDoubled(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for(int cur : arr){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        for(int cur : arr){
            if(cur == 0){
                if(map.getOrDefault(cur, 0) % 2 == 1) return false;
                map.remove(0);
                continue;
            }
            if(map.containsKey(cur * 2) && map.containsKey(cur)){
                if(map.get(cur) == 1){
                    map.remove(cur);
                }
                else{
                    map.put(cur, map.get(cur) - 1);
                }
                if(map.get(cur * 2) == 1){
                    map.remove(cur * 2);
                }
                else{
                    map.put(cur * 2, map.get(cur * 2) - 1);
                }
            }
        }
        System.out.println(map.toString());
        return map.isEmpty();
    }
}
