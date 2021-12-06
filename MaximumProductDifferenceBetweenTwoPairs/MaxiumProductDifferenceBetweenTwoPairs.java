package MaximumProductDifferenceBetweenTwoPairs;

public class MaxiumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args){
        int[] array = {5,6,2,7,4};

        //mergeSort(array, 0, array.length - 1);

        //printArray(array);
        System.out.print(maxProductDifference(array));
    }

    static int maxProductDifference(int[] nums){
        int ans;
        mergeSort(nums, 0, nums.length - 1);
        ans = nums[nums.length - 1]* nums[nums.length - 2] - nums[0]*nums[1];
        return ans;

    }

    static void mergeSort(int[] array, int head, int end){
        if(end > head){
            int mid = head + (end - head) / 2;
            
            mergeSort(array, head, mid);
            mergeSort(array, mid + 1, end);

            sort(array, head, mid, end);
        }
    }
    
    static void sort(int[] array, int head, int mid, int end){
        int leftSize = mid - head + 1, rightSize = end - mid ;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for(int i = 0; i < leftSize; i++){
            left[i] = array[head + i];
        }
        for(int i = 0; i < rightSize; i++){
            right[i] = array[mid + i + 1];
        }
        
        int leftIndex = 0, rightIndex = 0, current = head;

        while(leftIndex < leftSize && rightIndex < rightSize){
            if(left[leftIndex] <= right[rightIndex]){
                array[current] = left[leftIndex];
                leftIndex++;
            }
            else{
                array[current] = right[rightIndex];
                rightIndex++;
            }
            current++;
        }

        while(leftIndex < left.length){
            array[current] = left[leftIndex];
            current++;
            leftIndex++;
        }
        while(rightIndex < right.length){
            array[current] = right[rightIndex];
            current++;
            rightIndex++;
        }
    }

    static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }
    
}
