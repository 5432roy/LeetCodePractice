package LinkedListRelatedProblem;

import java.util.*;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthNodeFromEnd(ListNode head, int n){
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        int length = 0;

        while(temp != null){
            map.put(length, temp);
            temp = temp.next;
            length++;
        }
        if(length == n) return head.next;
        temp = map.get(length - n - 1);
        temp.next = temp.next.next;
        return head;
    }

    //twoPointerVersion
    public ListNode removeNthNodeFromEnd2(ListNode head, int n){
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode front = head;
        ListNode back = newHead;

        while(n > 1){
            front = front.next;
            n--;
        }

        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return newHead.next;
    }
    
}
