package GettheMaximumScore;

public class GetMaxSum {

    public int maxSum(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0, n = nums1.length, m = nums2.length;
        long top = 0, down = 0, mod = (long)1e9 + 7;
        while (index1 < n || index2 < m) {
            if (index1 < n && (index2 == m || nums1[index1] < nums2[index2])) {
                top += nums1[index1++];
            } else if (index2 < m && (index1 == n || nums1[index1] > nums2[index2])) {
                down += nums2[index2++];
            } else {
                top = down = Math.max(top, down) + nums1[index1];
                index1++; index2++;
            }
        }
        return (int)(Math.max(top, down) % mod);
    }
    
}
