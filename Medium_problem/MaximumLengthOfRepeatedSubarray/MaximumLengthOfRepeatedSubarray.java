package MaximumLengthOfRepeatedSubarray;

public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args){
        int[] nums1 = {1,2,3,2,5};
        int[] nums2 = {2,3,2,5,7};

        System.out.println(findLength(nums1,nums2));
    }

    public static int findLength(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length][nums2.length];
        int length = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0 ; j < nums2.length; j++){
                if(i == 0 || j == 0) dp[i][j] = nums1[i] == nums2[j] ? 1 : 0;
                else dp[i][j] = nums1[i] == nums2[j] ? dp[i-1][j-1] + 1 : 0;
                length = Math.max(length, dp[i][j]);
            }
        }
        return length;
    }
    
}
