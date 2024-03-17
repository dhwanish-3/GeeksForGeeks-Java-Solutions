class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private Node mergeSortedLists(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        while (true) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return dummy.next;

    }

    public Node sort(Node head) {
        // your code here, return the head of the sorted list
        Node ascend = head;
        Node ascendHead = head;
        Node descend = head.next;
        Node descendHead = head.next;
        while (ascend.next != null && descend.next != null) {
            if (ascend.next != null) {
                ascend.next = ascend.next.next;
                ascend = ascend.next;
            }
            if (descend.next != null) {
                descend.next = descend.next.next;
                descend = descend.next;
            }
        }
        ascend.next = null;
        descendHead = reverse(descendHead);
        return mergeSortedLists(ascendHead, descendHead);
    }
}