class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        Node cur = head;
        Node first = head;
        while (cur.next != null && k-- > 1) {
            cur = cur.next;
        }
        head = cur.next;
        Node node = cur.next;
        cur.next = null;
        if (node == null) return first;
        while (node.next != null) {
            node = node.next;
        }
        node.next = first;
        return head;
    }
}