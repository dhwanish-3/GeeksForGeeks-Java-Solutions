class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
        Node head = null;
        Node tail = null;
        while(head1!=null && head2!=null){
            if(head1.data == head2.data){
                if(head == null){
                    head = new Node(head1.data);
                    tail = head;
                }else{
                    tail.next = new Node(head1.data);
                    tail = tail.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            }else if(head1.data < head2.data){
                head1 = head1.next;
            }else{
                head2 = head2.next;
            }
        }
        return head;
    }
}