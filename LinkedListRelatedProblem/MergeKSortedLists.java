package LinkedListRelatedProblem;
import java.util.*;
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists){
        ListNode root = new ListNode();
        ListNode prev = root;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(ListNode node : lists){
            while(node != null) {
                heap.add(node.val);
                node = node.next;
            }
        }
        while(!heap.isEmpty()){
            ListNode cur = new ListNode(heap.poll());
            prev.next = cur;
            prev = cur;
        }
        return root.next;
    }
    
}
// comparator example
//        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Compare());
class Compare implements Comparator<ListNode>{
              
    public int compare(ListNode s1, ListNode s2) {
        if (s1.val < s2.val)
            return 1;
        else if (s1.val > s2.val)
            return -1;
                        return 0;
        }
}
