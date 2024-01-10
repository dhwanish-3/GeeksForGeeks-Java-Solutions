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
    Node mergeResult(Node node1, Node node2)
    {
	    Node cur = null;
	    while (node1 != null || node2 != null) {
	        if (node1 != null && node2 != null) {
	            if (node1.data < node2.data) {
	                Node newNode = new Node(node1.data);
	                newNode.next = cur;
	                cur = newNode;
	                node1 = node1.next;
	            } else {
	                Node newNode = new Node(node2.data);
	                newNode.next = cur;
	                cur = newNode;
	                node2 = node2.next;
	            }
	        }
	        else if (node1 != null) {
	            Node newNode = new Node(node1.data);
	            newNode.next = cur;
                cur = newNode;
                node1 = node1.next;
	        } else {
	            Node newNode = new Node(node2.data);
	            newNode.next = cur;
	            cur = newNode;
	            node2 = node2.next;
	        }
	    }
	    return cur;
    }
}