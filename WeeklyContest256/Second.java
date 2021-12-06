package WeeklyContest256;
import java.util.*;
public class Second {

    public String kthLargestNumber(String[] strs, int k){
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for(String str : strs){
            map.putIfAbsent(str.length(), new ArrayList<>());
            map.get(str.length()).add(str);
        }
        while(!map.isEmpty()){
            int size = map.lastEntry().getValue().size();
            if(size < k) {
                k -= size;
                map.remove(map.lastKey());
            }
        }

        return getRes(map.lastEntry().getValue(), k);
    }

    public String getRes(List<String> list, int k){
        Collections.sort(list);
        return list.get(list.size() - k);
    }

    
}
