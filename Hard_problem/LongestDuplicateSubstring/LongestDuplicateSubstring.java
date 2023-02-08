package LongestDuplicateSubstring;
import java.util.*;
public class LongestDuplicateSubstring {

    public String longestDupSubstring(String s) {
        // rolling hash, and some special algorithm, is too hard for actually practice 
        HashSet<String> sub = new HashSet<>();
        PriorityQueue<String> heap = new PriorityQueue<>((a,b) -> b.length() - a.length());

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String cur = s.substring(i, j + 1);
                if(sub.contains(cur)){
                    heap.add(cur);
                    continue;
                }
                sub.add(cur);
            }
        }


        return heap.size() == 0 ? null :heap.poll();
    }
    
}
