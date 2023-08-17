package SlidingWindowMaximum;

class Solution {
    /* 
     * 239. Sliding Window Maximum
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. 
     * Each time the sliding window moves right by one position.
     * Return the max sliding window.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        // edge case that k >= than the entire array
        if(k >= n) {
            int max = Integer.MIN_VALUE;
            for(int num : nums) {
                max = Math.max(num, max);
            }
            res[0] = max;
            return res;
        }
        
        // max heap that depends on the 0th index, if same value, min heap for 1th index.
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0]) {
                    return Integer.compare(array2[0], array1[0]);
                } else {
                    return Integer.compare(array1[1], array2[1]);
                }
            }
        });

        // add k - 1 number into the heap for initial set up
        for(int i = 0; i < k - 1; i++) {
            heap.add(new int[]{nums[i], i});
        }

        // everytime the window move to the right, check if the largest number is still in the window
        // if not, remove it
        // add newest number into the heap
        // peek for the maximum
        for(int i = 0; i <= n - k; i++) {
            while(!heap.isEmpty() && heap.peek()[1] < i) {
                heap.poll();
            }
            heap.add(new int[]{nums[i + k - 1], i + k - 1});
            res[i] = heap.peek()[0];
        }

        return res;
    }
}