/**
 * 2402. Meeting Rooms III
 * 
 * You are given an integer n. There are n rooms numbered from 0 to n - 1.
 * You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). 
 * All the values of starti are unique.
 * Meetings are allocated to rooms in the following manner:

 * Each meeting will take place in the unused room with the lowest number.
 * If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
 * When a room becomes unused, meetings that have an earlier original start time should be given the room.
 * 
 * Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
 * A half-closed interval [a, b) is the interval between a and b including a and not including b.
 * 
 * https://leetcode.com/problems/meeting-rooms-iii/description/
 */
class Solution {
    /**
     * using two heaps to keep track of the usage of meeting rooms
     * for each meeting, we first check if there are previous meetings ended for current the meeting time
     * if ended, those room are free
     * 
     * if there are free rooms, we used it based on the room number and add it into using room heap
     * if there is no free room, we poll one room from the used room and used that room. 
     */
    public int mostBooked(int n, int[][] meetings) {
        int[] rooms = new int[n];
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<int[]> using = new PriorityQueue<>((a, b) -> (a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));
        
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < n; i++) {
            free.offer(i);
        }

        for(int[] meeting : meetings) {
            while(using.size() > 0 && using.peek()[1] <= meeting[0]) {
                free.offer(using.poll()[0]);
            }

            int nextRoom = -1;
            if(free.size() > 0) {
                nextRoom = free.poll();
                using.offer(new int[]{nextRoom, meeting[1]});
            } else {
                int[] room = using.poll();
                nextRoom = room[0];
                using.offer(new int[]{room[0], room[1] - meeting[0] + meeting[1]});
            }
            rooms[nextRoom]++;
        }

        int freq = -1, res = -1;
        for(int i = 0; i < n; i++) {
            if(rooms[i] > freq) {
                freq = rooms[i];
                res = i;
            }
        }

        return res;
    }
}