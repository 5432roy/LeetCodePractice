package CountWordsObtainedAfterAddingaLetter;

import java.util.*;
import java.util.stream.Collectors;

public class CountWordsObtainedAfterAddingaLetter {
    public int wordCount(String[] startWords, String[] targetWords) {
        int[] hash = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        ArrayList<Long> start = new ArrayList<>();
        ArrayList<Long> end = new ArrayList<>();
        
        for(String str : startWords){
            long cur = 1;
            for(char ch : str.toCharArray()){
                cur *= hash[ch - 'a'];
            }
            start.add(cur);
        }
        
        for(String str : targetWords){
            long cur = 1;
            for(char ch : str.toCharArray()){
                cur *= hash[ch - 'a'];
            }
            end.add(cur);
        }
        Collections.sort(end);;
        int res = 0;
        HashSet<Integer> check = new HashSet<>(Arrays.stream(hash).boxed().collect(Collectors.toSet()));
        for(long cur : start){
            for(long word : end){
                if(word < cur) break;
                if(check.contains((word % cur))) {
                    res++;
                    break;
                }
            }
        }
    
        return res;
        
    }
    
}
