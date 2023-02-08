package Remove_All_adjacent_Duplicates_In_String;

import java.util.Stack;

public class Remove_All {
    public static void main(String[] args){
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
    public static String removeDuplicates(String s){
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean next;
        String ans;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);  
            next = true;
            if(!stack.isEmpty()){
                if(stack.peek() == c) {
                    stack.pop();
                    next = false;
                }
            } 
            if(next) stack.add(s.charAt(i));
        }
        while(!stack.isEmpty()) builder.append(stack.pop());
        ans = builder.reverse().toString();
        return ans;
    }
}
