class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Solution
{
    private static Node sortedInsert(Node head, Node newNode) {
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            return newNode;
        }
        Node curr = head;
        while (curr.next != null && curr.next.data < newNode.data) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
    public static Node insertionSort(Node head_ref)
    {
        if (head_ref == null || head_ref.next == null) {
            return head_ref;
        }
        Node sorted = null;
        Node curr = head_ref;
        while (curr != null) {
            Node next = curr.next;
            sorted = sortedInsert(sorted, curr);
            curr = next;
        }
        return sorted;
    }
}