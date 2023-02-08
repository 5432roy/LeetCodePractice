package DistinctSubsequences;

public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];
    
        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[0][j] = 1;
        }
        
        // the first column is 0 by default in every other rows but the first, which we need.
        
        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j];
                }
            }
        }
        
        return mem[T.length()][S.length()];
    }
    //TLE
    public int TLEnumDistinct(String s, String t) {
        int res = 0;
        StringBuilder builder = new StringBuilder();
        res += dfs(s, t, builder, 0, 0);
        return res;
    }

    public int dfs(String s, String t, StringBuilder builder, int index, int cur){
        if(builder.toString().equals(t)) return 1;
        if(index >= s.length()) return 0;
        int res = 0;
        for(int i = index; i < s.length(); i++){
            if(s.charAt(index) == t.charAt(cur)){
                int l = builder.length();
                builder.append(s.charAt(index));
                res += dfs(s, t, builder, i + 1, cur + 1);
                builder.setLength(l);
            }
        }
        return res;
    }

    
}
