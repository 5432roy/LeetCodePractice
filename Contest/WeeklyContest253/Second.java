package WeeklyContest253;
import java.util.*;
public class Second {

    public static void main(String[] args){
        int[] piles = {7481,7973,3635,5320,2721,4394,7861}; // 13*** 10
        //int[] piles = {15,14,13,6,5,4};
        //int[] piles = {10,10,3};
        int res = minStoneSum(piles, 10);
        System.out.println(Arrays.toString(piles) + ", " + res);
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : piles) heap.add(stone);

        while(k > 0){
            k--;
            int temp = heap.poll();
            temp -= temp / 2;
            heap.add(temp); 
        }
        int sum = 0;
        for(int stone : heap){
            sum += stone;
        }
        return sum;
    }
    
}
