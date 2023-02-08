package ShortEncodingofWords;
import java.util.*;
public class ShortEncodingofWords {

    public int minimumLengthEncoding(String[] words) {
        HashSet<String> hash = new HashSet<>();
        int res = 0;
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        
        for(String word : words) {
            if(hash.contains(word)) continue;
            res += word.length() + 1;    
            for(int i = 0; i < word.length(); i++) {
                if(hash.contains(word.substring(i))) break;
                hash.add(word.substring(i));
            }
        }
        
        return res;
    }
    
}
