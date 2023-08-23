package ReorganizeString;

class Solution {
    /*
     * 767. Reorganize String
     * 
     * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
     * Return any possible rearrangement of s or return "" if not possible.
     */

    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // to keep track of which character has the most remaining
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((h1, h2) -> Integer.compare(h2[1], h1[1]));
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                heap.add(new Integer[]{i, count[i]});
            }
        }
        
        StringBuilder res = new StringBuilder(); // build the string for result
        int previous = -1; // keep track of the previous character so that any two adjacent characters are not the same.

        // keep going until all character are added into res
        while(!heap.isEmpty()) {
            // cur is the character that has the highest frequency so far
            Integer[] cur = heap.poll();
            // if there is no more character other than the previous one, it is impossilbe to build such a string
            if(cur[0] == previous && heap.isEmpty()) {
                return "";
            } else if(cur[0] == previous) { // otherwise, we append second highest freq char instead 
                Integer[] next = heap.poll();

                res.append((char)(next[0] + 'a'));

                next[1]--;
                previous = next[0];

                if(next[1] > 0) {
                    heap.add(next);
                }
                heap.add(cur);
            } else { // if the character has nothing to do with the previous char, just append this one
                res.append((char)(cur[0] + 'a'));

                cur[1]--;
                previous = cur[0];

                if(cur[1] > 0) {
                    heap.add(cur);
                }
            }
        }

        return res.toString();

    }
}