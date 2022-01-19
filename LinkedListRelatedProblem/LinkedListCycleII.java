package LinkedListRelatedProblem;
import java.util.*;
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        ListNode runner = head;
        while(runner != null){
            if(seen.contains(runner)) return runner; 
            seen.add(runner);
            runner = runner.next;
        }
        return null;
    }
}
