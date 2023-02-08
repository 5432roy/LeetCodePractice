package DeleteOperationForTwoStrings;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }
    
    private int helper(String word1, String word2, int i, int j) {
        if(i == word1.length() && j == word2.length()) return 0;
        if(i == word1.length()) return 1 + helper(word1, word2, i, j + 1);
        if(j == word2.length()) return 1 + helper(word1, word2, i + 1, j);
        if(word1.charAt(i) == word2.charAt(j)) return helper(word1, word2, i + 1, j + 1);
        return 1 + Math.min(helper(word1, word2, i + 1, j), helper(word1, word2, i, j + 1));
    }
}
