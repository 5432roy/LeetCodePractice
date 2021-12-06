package InsertDeleteGetRandom;
import java.util.*;
public class RandomizedSet {
    
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int pos = map.get(val);
        if(pos < list.size() - 1){
            list.set(pos, list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), pos);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
