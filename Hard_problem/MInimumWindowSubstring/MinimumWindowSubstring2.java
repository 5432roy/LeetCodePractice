/**
 * 76. Minimum Window Substring
 * 
 * Given two strings s and t of lengths m and n respectively, 
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
 * If there is no such substring, return the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * https://leetcode.com/problems/minimum-window-substring/
 */

class Solution {
    /**
     * `need` keep track of the character we need from t
     * `have` keep track of the character we have more than needed
     * 
     * if there is nothing in `need`, it is a valid substring
     * if the character at start is in `have`, we can proceed our start to next index
     */
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> have = new HashMap<>();

        for(char cur : t.toCharArray()) {
            need.put(cur, need.getOrDefault(cur, 0) + 1);
        }

        int start = 0, n = s.length(), best = Integer.MAX_VALUE;
        String res = "";

        for(int end = 0; end < n; end++) {
            char cur = s.charAt(end);
            if(need.size() > 0 && need.containsKey(cur)) {
                int freq = need.get(cur) - 1;
                if(freq == 0) {
                    need.remove(cur);
                } else {
                    need.put(cur, freq);
                }
            } else {
                have.put(cur, have.getOrDefault(cur, 0) + 1);
            }

            while(have.size() > 0 && have.containsKey(s.charAt(start))) {
                int freq = have.get(s.charAt(start)) - 1;
                if(freq == 0) {
                    have.remove(s.charAt(start));
                } else {
                    have.put(s.charAt(start), freq);
                }
                start++;
            }

            if(need.size() == 0 && end - start < best) {
                res = s.substring(start, end + 1);
                best = end - start;
            }
        }

        return res;
    }
}