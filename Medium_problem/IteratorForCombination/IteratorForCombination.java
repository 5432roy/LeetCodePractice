package IteratorForCombination;

import java.util.*;

public class IteratorForCombination {

    TreeSet<String> set;
    Iterator<String> entry;

    public IteratorForCombination(String str, int l) {
        set = new TreeSet<>();
        helper(str, new StringBuilder(), 0, l);
        entry = set.iterator();
    }
    
    private void helper(String str, StringBuilder cur, int start, int l){
        if(cur.length() == l){
            set.add(cur.toString());
            return;
        }

        for(int i = start; i < str.length(); i++){
            cur.append(str.charAt(i));
            helper(str, cur, i + 1, l);
            cur.setLength(cur.length() - 1);
        }
    }
    
    public String next() {
        return hasNext() ? entry.next() : null;
    }
    
    public boolean hasNext() {
        return entry.hasNext();
    }
    
}
