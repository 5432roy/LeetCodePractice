package ImplementTire;

class TrieNode{
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

public class ImplementTrie {
    
    private TrieNode node;
    public ImplementTrie(){
        node = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode cur = node;
        for(char ch : word.toCharArray()){
            if(cur.children[ch - 'a'] == null){
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word){
        TrieNode cur = node; 
        for(char ch : word.toCharArray()){
            if(cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix){
        TrieNode cur = node; 
        for(char ch : prefix.toCharArray()){
            if(cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
        }
        return true;
    }

}
