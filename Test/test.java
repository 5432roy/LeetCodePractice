package Test;
import BinaryShortestPath.BinaryShortestPath;
public class test {
    public static void main(String[] args) {
        BinaryShortestPath test1 = new BinaryShortestPath();
        int[][] matrix = new int[][]{
            {0,0,1},
            {1,1,0},
            {0,1,0}
        };
        System.out.println(test1.solution(matrix));
    }
}
