class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            temp.next = temp;
            head = temp;
        } else if (head.data >= temp.data) {
            Node last = head;
            while (last.next != head)
                last = last.next;
            last.next = temp;
            temp.next = head;
            head = temp;
        } else {
            Node current = head;
            while (current.next != head && current.next.data < temp.data)
                current = current.next;
            temp.next = current.next;
            current.next = temp;
        }
        return head;
    }
}