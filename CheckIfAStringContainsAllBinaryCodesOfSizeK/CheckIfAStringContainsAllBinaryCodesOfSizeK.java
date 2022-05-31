package CheckIfAStringContainsAllBinaryCodesOfSizeK;
import java.util.HashSet;
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        int res = 1 << k;
        
        for(int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
            if(set.size() == res) return true;
        }

        return false;
    }
    
}
