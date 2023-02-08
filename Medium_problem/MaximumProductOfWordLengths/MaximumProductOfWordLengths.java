package MaximumProductOfWordLengths;
import java.util.ArrayList;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String word : words) {
            int current = 0;
            int[] memo = new int[26];
            
            for(char ch : word.toCharArray()) {
                memo[(ch - 'a')] = 1;
            }
            
            for(int i = 0; i < 26; i++) {
                current += memo[i] == 1 ? (1 << i) : 0;
            }
            
            list.add(current);
        }
        
        for(int i = list.size() - 1; i >= 0; i--) {
            int current = list.get(i);
            
            for(int j = 0; j < i; j++) {
                if((list.get(j) & current) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        
        return res;
    }
    
}
