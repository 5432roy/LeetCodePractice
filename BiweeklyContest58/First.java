package BiweeklyContest58;

public class First {

    public String makeFancyString(String s) {
        int prev = 1;
        char cur = s.charAt(0);
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == cur) prev++;
            else{
                cur = s.charAt(i);
                prev = 1;
            }
            if(prev == 3) continue;
            builder.append(s.charAt(i));
        }

        return s;
    }
    
}
