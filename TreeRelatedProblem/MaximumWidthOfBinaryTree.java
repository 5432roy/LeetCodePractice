package TreeRelatedProblem;
import java.util.*;
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root){
        List<Integer> list = new ArrayList<>();
        return dfs(root, list, 0, 0);
    }
    //Since we will retrun the answer directly from this recursive funciton
    //the return value of recursive function should be able to answer the question itself
    //For this question, the subproblem is the maximum width among this level and the next level
    //So we return max from next level and compare it with our current level
    private int dfs(TreeNode node, List<Integer> list, int index, int level){
        if(node == null) return 0;

        if(list.size() <= level) list.add(index);
        int nextLevelMax = Math.max(dfs(node.left, list, index * 2, level + 1), dfs(node.right, list, index * 2 + 1, level + 1));
        return Math.max(index - list.get(level) + 1, nextLevelMax);
    }
    
}
