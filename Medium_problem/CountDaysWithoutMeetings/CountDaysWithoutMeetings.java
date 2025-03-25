package Medium_problem.CountDaysWithoutMeetings;

/*
 * 3169. Count Days Without Meetings
 * https://leetcode.com/problems/count-days-without-meetings/description/?envType=daily-question&envId=2025-03-24
 * 
 * Straight forward array sorting question.
 * Sort the array by the starting time so that no processed meeting will affect the existing result
 * 
 * Case 1: next meeting is not consecutive with the previous meeting >> count the days work in the previous session, and reset the start and end time
 * Case 2: next meeting ends after the current end time >> update the end time
 * Case 3: next meeting ends before the current end time >> ignore
 */

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        int start = 0, end = 0, res = days;

        for(int[] meeting : meetings) {
            /* Not necessary line */
            // if(meeting[1] <= end) {
            //     continue;
            // }
            if(meeting[0] > end) {
                res -= end - start + 1;
                start = meeting[0];
                end = meeting[1];
            } else {
                end = Math.max(end, meeting[1]);
            }
        }
        res -= end - start;

        return res;    
    }
}