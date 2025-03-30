/*
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/?envType=daily-question&envId=2025-03-30
 * 
 * Find the last index of every character in the string
 * Iterate from the beginning and see if we can cut the string
 * if there is a same character (not the current one) that are in the back, we update the `end` accordingly
 * `end` is the earliest point we can make a cut
 * If we iterate over `end`, that means we can have a cut here.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> tail = new HashMap<>();

        for(int i = s.length() - 1; i >= 0; i--) {
            if(tail.containsKey(s.charAt(i))) {
                continue;
            }
            tail.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            int cur = tail.get(s.charAt(i));
            if(cur != i && cur > end) {
                end = cur;
            }
            if(i >= end) {
                res.add(end - start + 1);
                start = end + 1;
                end = start;
            }
        }

        if(start != end) {
            res.add(end - start + 1);
        }

        return res;
    }
}