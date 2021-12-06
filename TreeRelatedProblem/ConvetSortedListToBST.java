package TreeRelatedProblem;

import java.util.*;

public class ConvetSortedListToBST {

    public TreeNode sortedListToBST(ListNode head){
        List<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        return helper(list, 0, list.size() - 1);        
    }

    private TreeNode helper(List<Integer> list, int start, int end){
        if(start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, start, mid - 1);
        root.right = helper(list, mid + 1, end);
        return root;
    }
    
}
