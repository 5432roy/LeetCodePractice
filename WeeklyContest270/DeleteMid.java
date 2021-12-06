package WeeklyContest270;

public class DeleteMid {

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;

        ListNode mid = head;
        ListNode prev = mid;
        ListNode runner = head;

        while(runner != null && runner.next != null){
            runner = runner.next.next;
            prev = mid;
            mid = mid.next;
        }

        if(runner == null){
            prev.next = mid.next;
        }
        else{
            mid.next = mid.next.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }   
}