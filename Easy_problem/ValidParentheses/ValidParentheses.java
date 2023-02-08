package ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        String s = "[]]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '[' || cur == '{') stack.add(cur);
            else{
                if(stack.isEmpty()) return false;
                char end = stack.pop();
                if((cur == ')' && end != '(') || (cur == ']' && end != '[') || (cur =='}' && end !='{')) return false;
            }
        }
        return stack.isEmpty();
    }
}
