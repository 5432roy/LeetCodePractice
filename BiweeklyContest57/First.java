package BiweeklyContest57;

public class First {
    public static void main(String[] args){
        String s = "aabbcc";
        areOccurrencesEqual(s);

    }
    public static boolean areOccurrencesEqual(String s) {
        int[] ch = new int[26];
        for(int i = 0; i < s.length(); i++){
            ch[s.charAt(i) - 'a']++;
        }
        int counts = 0;
        for(int i : ch){
            if(counts == 0) counts = i;

            if(counts != i && i != 0) return false;
        }

        return true;
    }
}
