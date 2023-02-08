package ExpressionAddOperators;
import java.util.*;
public class ExpressionAddOperators {
    List<String> res;
    public List<String> addOperators(String num, int target){
        res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(res, builder, num, 0, target, 0, 0);

        return res;
    }

    public void dfs(List<String> res, StringBuilder builder, String num, int pos, int target, long prev, long multi) { 
        if(pos == num.length()) {
            if(target == prev) res.add(builder.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = builder.length();
            if(pos == 0) {
                dfs(res, builder.append(curr), num, i + 1, target, curr, curr); 
                builder.setLength(len);
            } else {
                dfs(res, builder.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
                builder.setLength(len);
                dfs(res, builder.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
                builder.setLength(len);
                dfs(res, builder.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
                builder.setLength(len);
            }
        }
    }
}
