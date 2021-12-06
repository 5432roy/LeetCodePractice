package MakeTheStringGreat;

import java.util.Stack;

public class MakeTheStringGreat {

    public static void main(String[] args){
        String case1 = "LeEeetcode";
        String str = "abc";
        System.out.println(str.substring(2));

        System.out.println(makeGood(case1));

    }
    
    public static String makeGood(String s){
        Stack<Character> stack = new Stack<>();
        String str = "";
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(stack.isEmpty()) stack.add(cur);
            else if(stack.peek() != cur && Character.toUpperCase(stack.peek()) == Character.toUpperCase(cur)){
                stack.pop();
            }
            else{
                stack.add(cur);
            }
        }
        while(!stack.isEmpty()){
            str = stack.pop() + str; 
        }
        return str;
    }
}
