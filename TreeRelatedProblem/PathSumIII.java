package TreeRelatedProblem;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum){
        return traversal(root, targetSum);
    }

    private int dfs(TreeNode node, int cur, int targetSum){
        if(node == null) return 0;
        return (cur + node.val == targetSum ? 1 : 0) + dfs(node.left, cur + node.val, targetSum) + dfs(node.right, cur + node.val, targetSum);
    }

    private int traversal(TreeNode node, int targetSum){
        if(node == null) return 0;

        return dfs(node, 0, targetSum) + traversal(node.left, targetSum) + traversal(node.right, targetSum);
    }
}
