package AlgorithmsSmaple;

public class Day_Stout_WarrenAlgorithm {

    public TreeNode balanceBST(TreeNode root){
        TreeNode grand = new TreeNode();
        grand.right = root;

        int length = makeVine(grand);
        int height = (int)(Math.log(length + 1) / Math.log(2));
        int m = (int)Math.pow(2, height) - 1;

        makeTree(grand, m);

        while(m / 2 > 0){
            m = m / 2;
            makeTree(grand, m);
        }

        return grand.right;
    }

    //turn the tree into a linked list
    private int makeVine(TreeNode grand){
        int length = 0;

        TreeNode cur = grand.right;

        while(cur != null){
            if(cur.left != null){
                TreeNode prev = cur;
                cur = cur.left;
                prev.left = cur.right;
                cur.right = prev;
                grand.right = cur;
            }
            else{
                grand = cur;
                cur = cur.right;
                length++;
            }
        }
        return length;
    }

    //turn the linked list back to Tree but balance
    private void makeTree(TreeNode grand, int m){
        TreeNode cur = grand.right;
        while(m > 0){
            TreeNode prev = cur;
            cur = cur.right;
            grand.right = cur;
            prev.right = cur.left;
            cur.left = prev;
            grand = cur;
            cur = cur.right;
            m--;
        }
    }
    
}
