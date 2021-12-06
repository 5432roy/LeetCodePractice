package BreakAPalindrome;

public class BreakAPalindrome {
    public String breakPalindrome(String str){
        if(str.length() == 1) return "";
        StringBuilder builder = new StringBuilder();
        boolean valid = false;
        int i = 0;
        //backtracking
        while(i < str.length()){
            if(str.length() % 2 != 0 && i == str.length() / 2){
                builder.append(str.charAt(i++));
                continue;
            }
            builder.append(valid ? str.charAt(i) : 'a');
            if(str.charAt(i++) != 'a') {
                valid = true;
            }
        }

        if(!valid){
            builder.setLength(str.length() - 1);
            builder.append('b');
        }

        return builder.toString();
    }
}
