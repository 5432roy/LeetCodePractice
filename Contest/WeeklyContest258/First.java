package WeeklyContest258;

public class First {

    public String reversePrefix(String word, char ch) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for(char cur : word.toCharArray()){
            builder.append(cur);
            i++;
            if(ch == cur) break;
        }
        if(i != word.length()) builder = builder.reverse();
        builder.append(word.substring(i, word.length()));

        return builder.toString();
    }

    //"rzwuktxcjfpamlonbgyieqdvhs"
    //"s"
    //"shvdqeiygbnolmapfjcxtkuwzr"
}
