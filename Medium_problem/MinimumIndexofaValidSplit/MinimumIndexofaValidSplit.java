/*
 * 2780. Minimum Index of a Valid Split
 * https://leetcode.com/problems/minimum-index-of-a-valid-split/description/
 * 
 * Approach
 * 1. Find the dominent number and count the total occurence of it
 * 2. Iterate from left to right and check if it is dominent on both side
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(), count = 0, res = 0, target = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            int cur = map.getOrDefault(num, 0) + 1;
            map.put(num, cur);
            if(cur > count) {
                target = num;
                count = cur;
            }
        }

        int left = 0;
        for(int i = 0; i < n; i++) {
            if(nums.get(i) == target) {
                left++;
            }
            
            if(left * 2 > (i + 1) && (count - left) * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;
    }
}