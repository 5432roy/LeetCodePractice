package FurthestBuildingYouCanReach;
import java.util.PriorityQueue;
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int res = 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        while(res < heights.length) {
            int cur = heights[res] - heights[res - 1];
            if(cur < 0) {
                res++;
                continue;
            }
            if(ladders > 0) {
                heap.offer(cur);
                ladders--;
            }
            else if(!heap.isEmpty() && cur > heap.peek()) {
                if(bricks >= heap.peek()) {
                    bricks -= heap.poll();
                    heap.offer(cur);   
                }
                else break;
            }
            else {
                if(bricks >= cur) {
                    bricks -= cur;
                }
                else break;
                
            }
            //System.out.println(bricks + ", " + heap.toString());
            res++;
        }
        
        return res - 1;
    }
}
