package WordSearch;
import java.util.*;

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}


    //one accpted solution but runtime complexity is very high
    public List<String> findWords(char[][] board, String[] words) {
        ArrayList<String> res = new ArrayList<>();
        int n = board.length, m = board[0].length;
        for(String word : words){
            boolean find  = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] == word.charAt(0)){
                        if(backTracking(board, new boolean[n][m], word, 0, i, j)){
                            res.add(word);
                            find = true;
                            break;
                        }
                    }
                }
                if(find) break;
            }    
        }

        return res;
    }

    int[] dir = new int[]{0,1,0,-1,0};
    private boolean backTracking(char[][] board, boolean[][] visited, String word, int index, int r, int c){
        if(index == word.length()) return true;
        if(!valid(board, r, c) || visited[r][c]) return false;
        if(!(board[r][c] == word.charAt(index))) return false;
        
        visited[r][c] = true;
        
        boolean res = false;
        for(int i = 0; i < dir.length - 1; i++){
            res = res || backTracking(board, visited, word, index + 1, r + dir[i], c + dir[i + 1]);
        }
        
        visited[r][c] = false;
        return res;
    }

    private boolean valid(char[][] board, int r, int c){
        return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }

/*
public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

            }
        }

        return res;
    }

    int[] dir = new int[]{0,1,0,-1,0};
    private void backTracking(char[][] board, boolean[][] visited, int r, int c, TrieNode node){
        if(valid(board, visited, r, c)) return;
        visited[r][c] = true;
        if(node.children[board[r][c] - 'a'] == null){
            node.children[board[r][c] - 'a'] = new TrieNode();
            node = node.children[board[r][c] - 'a'];
        }
        for(int i = 0; i < dir.length - 1; i++){
            backTracking(board, visited, r + dir[i], c + dir[i + 1], node);
        }
        visited[r][c] = false;
    }

    private boolean valid(char[][] board, boolean[][] visited, int r, int c){
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length && !visited[r][c];
    }
    */
}
