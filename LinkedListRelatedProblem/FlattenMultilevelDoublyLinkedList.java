package LinkedListRelatedProblem;

public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node node){
        
        Node cur = node;

        while(cur != null){
            helper(cur);
            cur = cur.next;
        }
        
        return node;
    }

    private void helper(Node node){

        Node child = node.child;

        if(child != null){
            Node next = node.next;
            node.next = child;
            child.prev = node;
            while(child.next != null) child = child.next;
            child.next = next;
            if(next != null) next.prev = child;
            node.child = null;
        }
    }
}
