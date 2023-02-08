package SortTheMatrixDiagonally;

import java.util.*;

public class SortTheMatrixDiagonally {
    public static void main(String[] args){
        int[][] matrix = new int[3][6];

        //Arrays.fill(matrix, 1);

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int[][] diagonalSort(int[][] mat){
        int row = mat.length, col = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                map.putIfAbsent(i - j, new PriorityQueue<Integer>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                mat[i][j] = map.get(i - j).poll();
            }
        }

        return mat;
    }
}
