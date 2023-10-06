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

class Solution
{
    public static void rearrange(Node odd)
    {
        if (odd == null || odd.next == null || odd.next.next == null) {
            return;
        }
        Node cur = odd.next.next;
        Node last = odd.next;
        Node lastTail = last;
        Node first = odd;
        Node next = null;
        int i = 3;
        while (cur != null) {
            next = cur.next;
            if (i % 2 == 0) {
                cur.next = last;
                last = cur;
            } else {
                first.next = cur;
                first = cur;
            }
            cur = next;
            i++;
        }
        lastTail.next = null;
        first.next = last;
    }
}