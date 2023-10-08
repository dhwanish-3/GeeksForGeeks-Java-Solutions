class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = head.next;
        Node cur = newHead.next;
        newHead.next = head;
        head.next = cur;
        Node next = null;
        Node prev = head;
        while (cur != null && cur.next != null) {
            next = cur.next.next;
            prev.next = cur.next;
            prev = cur;
            cur.next.next = cur;
            cur.next = next;
            cur = next;
        }
        return newHead;
    }
}