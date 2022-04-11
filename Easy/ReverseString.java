package Easy;

public class ReverseString {

    public void reverseString(char[] s) {
        int n = s.length / 2, l = s.length - 1;
        for(int i = 0; i < n; i++) {
            char temp = s[i];
            s[i] = s[l - i];
            s[l - i] = temp;
        }
    }
    
}
