class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class GfG
{
    Node deleteNode(Node head, int x)
    {
        if (head == null) {
            return null;
        }
        if (x == 1) {
            return head.next;
        }
        Node cur = head;
        int i = 1;
        while (cur.next != null) {
            if (i == x - 1) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            i++;
        }
        return head;
    }
}