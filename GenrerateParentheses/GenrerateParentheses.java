package GenrerateParentheses;

import java.util.*;


//Using DFS Algorithms

public class GenrerateParentheses {
    public static void main(String[] args){
        System.out.println(generateParentheses(3));
    }

    public static List<String> generateParentheses(int n){
        List<String> ans = new ArrayList<>();
        generate(n, n, "", ans);
        return ans;
    }

    public static void generate(int left, int right, String cur, List<String> ans){
        if(left > 0){
            //System.out.println(cur + "("+", " + ans);
            generate(left - 1, right, cur + "(", ans);
        }
        
        if(right > left){
            //System.out.println(cur + ")"+", " + ans);
            generate(left, right - 1, cur + ")", ans);
        }

        if(left == 0 && right == 0){
            ans.add(cur);
            return;
        }
    }
}
