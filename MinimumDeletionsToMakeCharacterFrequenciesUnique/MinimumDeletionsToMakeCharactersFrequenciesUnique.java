package MinimumDeletionsToMakeCharacterFrequenciesUnique;
import java.util.*;
public class MinimumDeletionsToMakeCharactersFrequenciesUnique {

    public int minDeletions(String s){
        int[] count = new int[26];
        for(char ch : s.toCharArray()) count[ch - 'a']++;
        Arrays.sort(count);

        int res = 0;
        for(int i = 25; i > 0; i--){
            while(count[i] <= count[i - 1] && count[i - 1] > 0){
                count[i - 1]--;
                res++;
            }
        }
        return res;

    }


}


