package ReverseWordsInString;
import java.util.*;
public class ReverseWordsInString {

    public static void main(String[] args){
        char a = ' ';
        System.out.println(a - 1);
    }

    public String reverseWords(String s){

        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for(String word : words){
            if(word.length() > 0){
                stack.push(word);
            }
        }

        while(!stack.isEmpty()){
            builder.append(stack.pop());
            if(!stack.isEmpty()) builder.append(" ");
        }

        return builder.toString();
    }
}
