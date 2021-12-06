package FindOriginalArrayFromDoubledArray;
import java.util.*;
public class FindOriginalArray {
    
    public int[] findOriginalArray2(int[] nums){
        if(nums.length % 2 != 0) return new int[]{};
        Arrays.sort(nums);
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            if(!deque.isEmpty() && i == deque.peekFirst()){
                deque.poll();
            }
            else{
                list.add(i);
                deque.addLast(i * 2);
            }
        }
        if(!deque.isEmpty()) return new int[]{};
        int[] res = new int[list.size()];
        int index = 0;
        for(int i : list){
            res[index++] = i;
        }

        return res;
    }

    //Using TreeMap
    public int[] findOriginalArray1(int[] nums){
        if(nums.length % 2 != 0) return new int[]{};
        Arrays.sort(nums);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();  
        int zero = 0;
        for(int i : nums){
            if(i == 0){
                zero++;
                continue;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if(zero % 2 != 0) return new int[]{};
        for(int key : map.keySet()){
            if(map.get(key) > map.getOrDefault(key * 2, 0)) return new int[]{};
            if(map.get(key) == 0) continue;
            for(int i = 0; i < map.get(key); i++){
                list.add(key);
            }
            map.put(key * 2, map.get(key * 2) - map.get(key));
        }
        for(int i = 0; i < zero / 2; i++){
            list.add(0);
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int i : list){
            res[index++] = i;
        }
        return res;
    }
}
