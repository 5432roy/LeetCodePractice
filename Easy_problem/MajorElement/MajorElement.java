/*
 * 169. Majority Element
 * 
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * 
 * https://leetcode.com/problems/majority-element/description/
 */
class Solution {
    /*
     * Since the result will be dominate in the entire array.
     * Count of `res` number > sum of all the other number
     * Only `res` will retain till end of the list. 
     */
    public int majorityElement(int[] nums) {
        int res = Integer.MAX_VALUE, count = 0;

        for(int num : nums) {
            if(num == res) {
                count++;
            } else {
                if(count == 0) {
                    res = num;
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        return res;
    }
}