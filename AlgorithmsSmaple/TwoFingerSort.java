package AlgorithmsSmaple;

public class TwoFingerSort{

    public static void main(String[] args){

    }

    public static int[] twoFingerSort(int[] left, int[] right){
        int leftIndex = 0, rightIndex = 0, current = 0;
        int[] sorted = new int[left.length + right.length];
        while(leftIndex < left.length && rightIndex < right.length){
            if(left[leftIndex] < right[rightIndex]){
                sorted[current] = left[leftIndex];
                leftIndex++;
            }
            else if(left[leftIndex] > right[rightIndex]){
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