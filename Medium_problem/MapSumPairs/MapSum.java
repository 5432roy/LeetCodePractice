package MapSumPairs;
import java.util.*;
public class MapSum {

    private HashMap<String, Integer> map;
    private HashMap<String, Integer> count;

    public MapSum(){
        map = new HashMap<>();
        count = new HashMap<>();
    }

    public void insert(String key, int val){
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for(char cur : key.toCharArray()){
            prefix += cur;
            count.put(prefix, count.getOrDefault(key, 0) + diff); 
        }
    }

    public int sum(String prefix){
        return count.getOrDefault(prefix, 0);
    }
    
}
