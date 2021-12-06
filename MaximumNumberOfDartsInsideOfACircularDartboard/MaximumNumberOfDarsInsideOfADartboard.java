package MaximumNumberOfDartsInsideOfACircularDartboard;

import java.util.*;

//not completed

public class MaximumNumberOfDarsInsideOfADartboard {

    public static void main(String[] args){
        int[][] points = {{-2,0},{2,0},{0,2},{0,-2}};
        numPoints(points, 0);
    }

    public static int numPoints(int[][] points, int r){
        int[] bound = bound(points);
        double[] mid = mid(points);
        for(int x = bound[0]; x >= bound[1]; x--){
            for(int y = bound[2]; y >= bound[3]; y--){

            }
        }

        System.out.println(Arrays.toString(bound));
        System.out.println(Arrays.toString(mid));
        return 0;
    }

    public static int[] bound(int[][] points){

        int[] bounds = new int[4];

        bounds[0] = bounds[1] = points[0][0];
        bounds[2] = bounds[3] = points[0][1];

        for(int row = 1; row < points.length; row++){
            bounds[0] = Math.max(bounds[0], points[row][0]);
            bounds[1] = Math.min(bounds[1], points[row][0]);
            bounds[2] = Math.max(bounds[2], points[row][1]);
            bounds[3] = Math.min(bounds[3], points[row][1]);
        }

        return bounds;
    }   
    

    public static double[] mid(int[][] points){
        double[] mid = new double[2];
        for(int row = 0; row < points.length; row++){
            mid[0] += points[row][0];
            mid[1] += points[row][1];
        }

        mid[0] /= points.length;
        mid[1] /= points.length; 

        return mid;
    }

    //public static double length
}
