package MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 ={3,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int length = nums1.length + nums2.length;

        double[] merge = twoFingerSort(nums1, nums2);

        if(length % 2 == 0){
            double ans = (merge[length / 2] + merge[length / 2 - 1]) / 2;
            return ans;
        }
        return merge[length / 2];
    }

    public static double[] twoFingerSort(int[] left, int[] right){
        int leftIndex = 0, rightIndex = 0, current = 0;
        double[] sorted = new double[left.length + right.length];
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] <= right[rightIndex]){
                sorted[current] = left[leftIndex];
                leftIndex++;
            }
            else{
                sorted[current] = right[rightIndex];
                rightIndex++;
            }
            current++;
        }
        while(leftIndex < left.length){
            sorted[current] = left[leftIndex];
            current++;
            leftIndex++;
        }
        while(rightIndex < right.length){
            sorted[current] = right[rightIndex];
            current++;
            rightIndex++;
        }
        return sorted;

    }
    
}
