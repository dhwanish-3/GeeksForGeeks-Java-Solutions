class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    static Node reverse(Node head) {
        Node next = null;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node substract(Node head1, Node head2) {
        Node prev1 = reverse(head1);
        Node prev2 = reverse(head2);
        Node tra1 = prev1;
        Node tra2 = prev2;
        while (tra1 != null) {
            if (tra2.data >= tra1.data) {
                tra2.data = tra2.data - tra1.data;
            } else {
                Node x = tra2.next;
                while (x != null && x.data == 0) {
                    x.data = 9;
                    x = x.next;
                }
                if (x != null) {
                    x.data = x.data - 1;
                }
                tra2.data = tra2.data + 10;
                tra2.data = tra2.data - tra1.data;
            }
            tra1 = tra1.next;
            tra2 = tra2.next;
        }
        Node ans = reverse(prev2);
        while (ans.next != null && ans.data == 0) {
            ans.data = ans.next.data;
            ans.next = ans.next.next;
        }
        return ans;
    }

    public Node subLinkedList(Node head1, Node head2) {
        Node temp = head1;
        while (temp.next != null && temp.data == 0) {
            temp.data = temp.next.data;
            temp.next = temp.next.next;
        }

        Node temp1 = head2;
        while (temp1.next != null && temp1.data == 0) {
            temp1.data = temp1.next.data;
            temp1.next = temp1.next.next;
        }

        if (head1.data == 0 && head2.data == 0)
            return new Node(0);
        if (head1.data == 0)
            return head2;
        if (head2.data == 0)
            return head1;

        int count1 = 0;
        int count2 = 0;
        temp = head1;
        temp1 = head2;
        while (temp != null) {
            count1++;
            temp = temp.next;
        }

        while (temp1 != null) {
            count2++;
            temp1 = temp1.next;
        }

        if (count1 == count2) {
            Node a = head1;
            Node b = head2;
            while (a != null && a.data == b.data) {
                a = a.next;
                b = b.next;
            }
            if (a == null || (a.data > b.data)) {
                return substract(head2, head1);
            } else {
                return substract(head1, head2);
            }
        }

        else if ((count1 > count2)) {
            return substract(head2, head1);
        } else {

            return substract(head1, head2);
        }
    }
}