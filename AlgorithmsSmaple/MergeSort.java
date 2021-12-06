package AlgorithmsSmaple;
import java.util.*;
public class MergeSort{

    public static void main(String[] args){
        int[] array = {5, 13, 9, 1, 8, 2, 18, 3, 5, 17, 3, 17, 12, 16, 15, 13, 19, 6, 17, 17};
        int[] sorted = {1, 2, 3, 3, 5, 5, 6, 8, 9, 12, 13, 13, 15, 16, 17, 17, 17, 17, 18, 19};
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i : array){
            list.add(i);
        }
        System.out.println(Arrays.toString(sorted));
        mergeSort(list, 0, list.size() - 1);
        System.out.println(list.toString());

    }
    public static void mergeSort(ArrayList<Integer> array, int head, int end){
        if (head < end) {
            // Find the middle point
            int mid = head + (end - head) / 2;
 
            // Sort first and second halves
            mergeSort(array, head, mid);
            mergeSort(array, mid + 1, end);
 
            // Merge the sorted halves
            sort(array, head, mid, end);
        }
    }

    public static void sort(ArrayList<Integer> array, int head, int mid, int end){
        int leftIndex = 0, rightIndex = 0, currentIndex = head;
        int leftSize = mid - head + 1, rightSize = end - mid;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        // store the value of the current sorting array
        for(int i = 0; i < leftSize; i++){
            left.add(array.get(head + i));
        }
        for(int i = 0; i < rightSize; i++){
            right.add(array.get(mid + i + 1));
        }

        while(leftIndex < leftSize && rightIndex < rightSize){
            if(left.get(leftIndex) < right.get(rightIndex)){
                array.set(currentIndex, left.get(leftIndex));
                leftIndex++;
            }
            else{
                array.set(currentIndex, right.get(rightIndex));
                rightIndex++;
            }
            currentIndex++;
        }

        while(leftIndex < leftSize){
            array.set(currentIndex, left.get(leftIndex));
            leftIndex++;
            currentIndex++;
        }
        while(rightIndex < rightSize){
            array.set(currentIndex, right.get(rightIndex));
            rightIndex++;
            currentIndex++;
        }
    }
    
}