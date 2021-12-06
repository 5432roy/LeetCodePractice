package KthSmallestElementInASortedMatrix;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args){
        int[][] matrix = {{1,5,11},{10,11,13},{12,13,15}};

        System.out.print(kth(matrix, 4));
    }
    public static int kth(int[][] matrix, int k){
        int[] array = new int[matrix.length*matrix.length];
        int index = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                array[index] = matrix[i][j];
                index++;
            }
        }
        Arrays.sort(array);

        return array[k];
    }
    
}
