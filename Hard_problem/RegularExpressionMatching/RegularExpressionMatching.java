package RegularExpressionMatching;

public class RegularExpressionMatching {

    public static void main(String[] args){
        String s = "aaa";
        String p = "ab*a*c*a";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p){
        if(s == null || p == null) return false;

        int m = s.length();
        int n = p.length();

        // M[i][j] means if p.subString(0,j) match s.subString(0,i)
        boolean[][] M = new boolean[m + 1][n + 1];

        M[0][0] = true;
        //find out if s is empty string which p.subString can match
        for(int j = 2; j < n + 1; j +=2){
            if(p.charAt(j - 1) == '*' && M[0][j - 2]){
                M[0][j] = true;
            }
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                if(curS == curP || curP == '.'){
                    M[i][j] = M[i - 1][j - 1];
                }else if(curP == '*'){
                    char preCurP = p.charAt(j - 2);
                    if(preCurP != '.' && preCurP != curS){
                        M[i][j] = M[i][j - 2];
                    }else{
                        M[i][j] = (M[i][j - 2] || M[i - 1][j - 2] || M[i - 1][j]);
                    }
                }
            }
        }
        
        return M[m][n];
    }
}
