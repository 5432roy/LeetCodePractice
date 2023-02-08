package BinaryTreeInorderTraversal;

import java.util.*;

public class BinaryTreeTraversal {
    
    public static void main(String[] args){
        TreeNode root = new TreeNode('A');
        TreeNode left = new TreeNode('E');
        TreeNode right = new TreeNode('F');
        TreeNode rightright = new TreeNode('I');
        TreeNode rightrightright = new TreeNode('C');
        TreeNode leftleft = new TreeNode('D');
        TreeNode leftright = new TreeNode('G');
        TreeNode leftrightleft = new TreeNode('B');

        root.left = left;
        root.right = right;
        rightright.right = rightrightright;
        right.right = rightright;
        left.left = leftleft;
        left.right = leftright;
        leftright.left = leftrightleft;


        Queue<Character> queue = new LinkedList<>();

        preOrder(root, queue);
        System.out.println("PreOrder:  " + queue.toString());
        queue.clear();

        inOrder(root, queue);
        System.out.println("InOrder:   " + queue.toString());
        queue.clear();

        postOrder(root, queue);
        System.out.println("PostOrder: " + queue.toString());
        queue.clear();
        
    }

    public static void inOrder(TreeNode node, Queue<Character> queue){
        
        if(node == null) return;

        inOrder(node.left, queue);

        queue.add(node.val);

        inOrder(node.right, queue);
    }

    public static void postOrder(TreeNode node, Queue<Character> queue){

        if(node == null) return;

        postOrder(node.left, queue);

        postOrder(node.right, queue);

        queue.add(node.val);
    }

    public static void preOrder(TreeNode node, Queue<Character> queue){

        if(node == null) return;

        queue.add(node.val);

        preOrder(node.left, queue);

        preOrder(node.right, queue);

    }
}
