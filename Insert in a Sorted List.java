class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        Node node = new Node(key);
        if (head.data >= key) {
            node.next = head;
            head = node;
            return head;
        }
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.data >= key) {
                node.next = cur;
                prev.next = node;
                return head;
            }
            prev = cur;
            cur = cur.next;
        }
        prev.next = node;
        return head;
    }
}