package InterleavingString;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int weridQuestion;
        if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0)){ 
            return s3 == null || s3.length() == 0;
        }
        if(s1 == null || s1.length() == 0) return s2.equals(s3);
        if(s2 == null || s2.length() == 0) return s1.equals(s3);
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean pathTable[][] = new boolean[s1.length() + 1][s2.length() + 1];
        pathTable[0][0] = true;
        
        for(int i = 1; i < pathTable.length; i++){
            if(pathTable[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1)){
                pathTable[i][0] = true;
            }
        }
        for(int j = 1; j < pathTable[0].length; j++){
            if(pathTable[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1)){
                pathTable[0][j] = true;
            }
        }
        for(int i = 1; i < pathTable.length; i++){
            for(int j = 1; j < pathTable[0].length; j++){
                if(pathTable[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    pathTable[i][j] = true;
                }
                else if(pathTable[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    pathTable[i][j] = true;
                }
            }
        }
        return pathTable[pathTable.length - 1][pathTable[0].length - 1];
    }
}
