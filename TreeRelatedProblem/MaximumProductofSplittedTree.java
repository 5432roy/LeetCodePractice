package TreeRelatedProblem;

public class MaximumProductofSplittedTree {

    public static void main(String[] args){
        System.out.println(1e9 + 7 - 100000007);
    }

    int temp = Integer.MAX_VALUE;
    public int maxProduct(TreeNode root){
        dfs(root);
        inOrder(root, root.val / 2);
        long res = temp * (root.val - temp) % ((long)1e9 + 7);
        return (int)res;
    }

    public int dfs(TreeNode node){
        if(node == null) return 0;
        return node.val += dfs(node.left) + dfs(node.right);
    }

    public void inOrder(TreeNode node, int target){
        
        if(node == null) return;

        inOrder(node.left, target);

        if(node.val >= target) temp = Math.min(temp, node.val);

        inOrder(node.right, target);
    }

    
}
