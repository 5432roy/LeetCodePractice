package Easy_problem;

import java.util.HashMap;

class ShortestCompletingWord {

    public String shortestCompletingWord(String str, String[] words){
        String res = null;
        str = str.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(ch < 123 && ch > 64){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        for(String word : words){
            HashMap<Character, Integer> temp = new HashMap<>(map);
            for(char cur : word.toCharArray()){
                if(temp.containsKey(cur)) {
                    temp.put(cur, temp.get(cur) - 1);
                    if(temp.get(cur) == 0) temp.remove(cur);
                }
            }
            if(temp.isEmpty() && (res == null || word.length() < res.length())) res = word;
        }
        return res;
    }
    
}
