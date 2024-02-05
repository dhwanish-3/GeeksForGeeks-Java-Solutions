class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head; // head of list
}

class Solution {
    long DecimalValue(Node head) {
        long mod = 1000000007;
        long sol = 0;
        while (head != null) {
            sol = (sol * 2 + head.data) % mod;
            head = head.next;
        }
        return sol % mod;
    }
}