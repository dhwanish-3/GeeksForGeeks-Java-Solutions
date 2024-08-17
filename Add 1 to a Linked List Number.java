class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    int carry = 0;
    private void rec(Node node) {
        if (node.next == null) {
            carry = (node.data + 1) / 10;
            node.data = (node.data + 1) % 10;
            return;
        }
        rec(node.next);
        if (carry > 0) {
            carry = (node.data + 1) / 10;
            node.data = (node.data + 1) % 10;
        }
    }
    public Node addOne(Node head) {
        // code here.
        rec(head);
        if (carry > 0) {
            Node root = new Node(1);
            root.next = head;
            return root;
        }
        return head;
    }
}
