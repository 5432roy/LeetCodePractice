package SortCharactersByFrequency;
import java.util.*;
public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        
        for(Character cur : s.toCharArray()){
            set.add(cur);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        
        for(Character cur : set){
            list.add(cur);
        }
        
        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));
        
        StringBuilder res = new StringBuilder();
        
        while(!list.isEmpty()){
            char cur = list.get(0);
            String str = Character.toString(cur);
            res.append(str.repeat(map.get(cur)));
            list.remove(0);
        }
        return res.toString();
    }
}
