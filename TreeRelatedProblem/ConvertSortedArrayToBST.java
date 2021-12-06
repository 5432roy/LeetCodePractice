package TreeRelatedProblem;

public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums){
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int head, int tail){
        if(head > tail) return null;

        int mid = head + (tail - head) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, head, mid - 1);
        node.right = buildTree(nums, mid + 1, tail);
        return node;
    }
    
}
