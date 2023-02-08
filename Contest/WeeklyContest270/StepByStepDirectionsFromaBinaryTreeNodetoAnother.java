package WeeklyContest270;
import java.util.*;
public class StepByStepDirectionsFromaBinaryTreeNodetoAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<Integer> cur = new ArrayList<>();
        ArrayList<Integer> startPath = new ArrayList<>();
        ArrayList<Integer> destPath = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        
        getPath(root, startValue, cur, startPath);
        getPath(root, destValue, cur, destPath);

        while(!startPath.isEmpty() && !destPath.isEmpty() && startPath.get(0) == destPath.get(0)){
            startPath.remove(0);
            destPath.remove(0);
        }
        String str = "U";
        res.append(str.repeat(startPath.size()));

        for(int i : destPath){
            res.append(i == 0 ? "L" : "R");
        }
        return res.toString();
    }
    // 0 == left, 1 == right
    private void getPath(TreeNode node, int value, ArrayList<Integer> cur, ArrayList<Integer> path){
        if(node == null) return;
        if(node.val == value){
            path.addAll(cur);
            return;
        }
        cur.add(0);
        getPath(node.left, value, cur, path);
        cur.remove(cur.size() - 1);
        cur.add(1);
        getPath(node.right, value, cur, path);
        cur.remove(cur.size() - 1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
 
}
