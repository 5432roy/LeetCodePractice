package FindKClosestElements;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, index = 0;
        int head = 0, tail = n - 1;
        while(head <= tail) {
            int mid = head + (tail - head) / 2;
            if(arr[mid] == x) {
                index = mid;
                break;
            }
            if(arr[head] > x || arr[tail] < x) {
                index = arr[head] > x ? head : tail;
                break;
            }
            if(arr[mid] > x) {
                tail = mid - 1;
            }
            else {
                head = mid + 1;
            }
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int max = Math.min(index + k + 1, n);
        for(int i = Math.max(index - k, 0); i < max; i++) {
            heap.offer(new int[]{Math.abs(arr[i] - x), arr[i]});
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < k; i++) {
            res.add(heap.poll()[1]);
        }
        Collections.sort(res);
        return res;
    }
}
