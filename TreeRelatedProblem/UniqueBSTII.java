package TreeRelatedProblem;
import java.util.*;
public class UniqueBSTII {

    public List<TreeNode> generateTrees(int end){
        if(end == 0 ) return null;
        return generateSubTree(1,end);
    }

    public List<TreeNode> generateSubTree(int start, int end){
        List<TreeNode> list = new ArrayList<>();

        if(start > end){
            list.add(null);
            return list;
        }

        for(int root = start; root <= end; root++){
            List<TreeNode> leftSubTree = generateSubTree(start, root - 1);
            List<TreeNode> rightSubTree = generateSubTree(root + 1, end);
            for(TreeNode left : leftSubTree){
                for(TreeNode right : rightSubTree){
                    TreeNode newRoot = new TreeNode(root);
                    newRoot.left = left;
                    newRoot.right = right;
                    list.add(newRoot);
                }
            }
        }

        return list;
    }   
    
}
