package CanConvertStringinKMoves;
import java.util.HashMap;
public class CanConvertStringinKMoves {

    public boolean canConvertString(String start, String end, int times){
        if(start.length() != end.length()) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        int need = 0;
        char[] endChars = end.toCharArray(), startChars = start.toCharArray();
        for(int i = 0; i < end.length(); i++){
            if(startChars[i] == endChars[i]) continue;
            int diff = startChars[i] < endChars[i] ? endChars[i] - startChars[i] : 26 - (startChars[i] - endChars[i]);
            if(map.containsKey(diff)) map.put(diff, map.get(diff) + 26);
            map.putIfAbsent(diff, diff);
        }

        for(int value : map.values()){
            need = Math.max(need, value);
        }

        return times >= need;
    }
    
}
