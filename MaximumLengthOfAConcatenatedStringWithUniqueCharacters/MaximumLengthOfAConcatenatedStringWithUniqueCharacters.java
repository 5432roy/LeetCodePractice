package MaximumLengthOfAConcatenatedStringWithUniqueCharacters;
import java.util.*;
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    
    int res = 0;
    public int maxLength(List<String> arr) {
        int[] bitmasks = new int[arr.size()];
        int index = 0;
        for(String str : arr){
            for(char ch : str.toCharArray()){
                if((bitmasks[index] >> ch - 'a' & 1) > 0){
                    bitmasks[index] = -1;
                    continue;
                }
                bitmasks[index] += 1 << ch - 'a';
            }
            index++;
        }
        for(int i = 0; i < arr.size(); i++){
            if(bitmasks[i] == -1) continue;
            backtracking(arr, bitmasks, i, 0, 0);
        }
        return res;
    }

    private void backtracking(List<String> arr, int[] bitmasks, int index, int cur, int length){
        res = Math.max(res, length);
        for(int i = index; i < bitmasks.length; i++){
            if(bitmasks[i] == -1) continue;
            boolean valid = (cur & bitmasks[i]) == 0;
            if(valid){
                cur += bitmasks[i];
                length += arr.get(i).length();
            }
            backtracking(arr, bitmasks, i + 1, cur, length);
            if(valid){
                cur -= bitmasks[i];
                length -= arr.get(i).length();
            }
        }
    }

}
