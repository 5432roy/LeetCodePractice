package TreeRelatedProblem;
import java.util.*;
public class BinaryTreeMaximumSum {

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode leftleft = new TreeNode(11);
        TreeNode leftleftleft = new TreeNode(7);
        TreeNode leftleftright = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        TreeNode rightLeft = new TreeNode(13);
        TreeNode rightright = new TreeNode(4);
        TreeNode rightrightright = new TreeNode(1);

        root.left = left;
        left.left = leftleft;
        leftleft.left = leftleftleft;
        leftleft.right = leftleftright;
        root.right = right;
        right.left = rightLeft;
        right.right = rightright;
        rightright.right = rightrightright; 

        maxPathSum(root);

        Queue<Integer> queue = new LinkedList<>();

        inOrder(root, queue);
        System.out.println(queue.toString());
        
    }

    public static void inOrder(TreeNode node, Queue<Integer> queue){
        
        if(node == null) return;

        inOrder(node.left, queue);

        queue.add(node.val);

        inOrder(node.right, queue);
    }


    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        root.val += Math.max(left, right);
        return root.val;
    }
    
}
