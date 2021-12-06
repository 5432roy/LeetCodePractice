package MergeTwoSortedLists;

public class MergeTwoSortedLists {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        l1.next = l12;

        ListNode l2 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        l2.next = l22;

        ListNode ans = mergeTwoLists(l1, l2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode ans = new ListNode();
        ListNode cur = ans;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return ans.next;
    }
}
