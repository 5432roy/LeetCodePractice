package BiweeklyContest57;

import java.util.*;

public class Second {
    public static void main(String[] args){
        int[][] times = {{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}};
        int[][] case2 = {{82057,89365},{32519,49655},{7573,20592},{8336,11514},{638,70162},{39511,44262},{70399,79785},{8702,63564},{66644,68330},{75156,90448},{11884,87096},{99068,99875},{32555,54053},{5910,77572},{87649,94390},{40084,56483},{7911,28699},{93308,96154},{25562,39605},{73966,93173},{63450,88007},{58811,80045},{56160,71952},{14333,79867},{40342,76876},{69943,82175}};

        System.out.println(smallestChair(times, 6));
        System.out.println(smallestChair(case2, 5));
    }

    private static void print(int[][] times){
        int[] a = new int[times.length];
        int[] b = new int[times.length];

        for(int i = 0; i < times.length; i++){
            a[i] = times[i][0];
            b[i] = times[i][1];
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static int smallestChair(int[][] times, int target){

        int arr = times[target][0];

        Arrays.sort(times, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        print(times);
        int index = 0;
        while(times[index][0] < arr) index++;

        boolean keep = true;
        while(keep){
            int prev = -1;
            int min = Integer.MAX_VALUE;
            keep = false;
            for(int i = 0 ; i < index; i++){
                if(times[i][1] <= times[index][0] && times[index][0] - times[i][1] < min){
                    keep = true;
                    min = times[index][0] - times[i][1];
                    prev = i;
                }
            }
            if(prev != -1) index = prev;
        }
        return index;
    }
}
