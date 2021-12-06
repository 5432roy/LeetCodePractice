package WeeklyContest262;
import java.util.*;
public class StockPrice {

    HashMap<Integer,Integer> map;
    TreeMap<Integer,Integer> value;
    int lastest;
    public StockPrice() {
        lastest = 0;
        map = new HashMap<>();
        value = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int cur = map.get(timestamp);
            value.put(cur, value.get(cur) - 1);
            if(value.get(cur) <= 0) value.remove(cur);
        }
        map.put(timestamp, price);
        value.put(price, value.getOrDefault(price, 0) + 1);
        lastest = Math.max(lastest, timestamp);

    }
    
    public int current() {
        return map.get(lastest);
    }
    
    public int maximum() {
        return value.lastKey();
    }
    
    public int minimum() {
        return value.firstKey();
    }
    
}
