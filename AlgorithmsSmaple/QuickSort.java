package AlgorithmsSmaple;
import java.util.*;
public class QuickSort {

    public static void main(String[] args){
        int[] arr = new int[1000000];
        generate(arr);
        int[] sort = arr.clone();
        Arrays.sort(sort);
        //System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));
        System.out.println(test(arr, sort));
    }

    public static boolean test(int[] arr, int[] sort){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] - sort[i] != 0) return false;
        }
        return true;
    }

    public static void generate(int[] arr){
        int n = arr.length;
        Random random = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = random.nextInt(n);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int head, int tail){
        int pivot = arr[tail];
        int position = head;

        for(int i = head; i < tail; i++){
            if(pivot > arr[i]){
                swap(arr, position, i);
                position++;
            }
        }
        swap(arr, position , tail);
        //System.out.println(Arrays.toString(arr));
        return position;
    }
    private static void quickSort(int[] arr, int head, int tail){
    
        if(head < tail){
            int position = partition(arr, head, tail);

            quickSort(arr, head, position - 1);
            quickSort(arr, position + 1, tail);
        }
    }


    
}
