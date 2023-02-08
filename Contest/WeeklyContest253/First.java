package WeeklyContest253;

public class First {

    public boolean isPrefixString(String s, String[] words) {
        int index = 0;
        for(String word : words){
            for(char cur : word.toCharArray()){
                if(index == s.length()) return false;
                if(cur != s.charAt(index++)) return false;
            }
            if(index == s.length()) break;
        }

        return true;
    }
    
}
