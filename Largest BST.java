class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
class Temp {
    int max, min;
    boolean isBST;
    int size;
    public Temp(int mi, int ma, boolean bst, int s) {
        max = ma;
        min = mi;
        isBST = bst;
        size = s;
    }
    public Temp() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        isBST = true;
        size = 0;
    }
}


class Sol {
    int ans = 1;
}

class Solution{
    static Temp rec(Node root, Sol sol) {
        if (root == null) return new Temp();
        Temp l = rec(root.left, sol);
        Temp r = rec(root.right, sol);
        Temp cur = new Temp();
        cur.size = 1 + l.size + r.size;
        cur.max = Math.max(root.data, r.max);
        cur.min = Math.min(root.data, l.min);
        if (l.isBST && r.isBST && (root.data > l.max && root.data < r.min)) {
            cur.isBST = true;
        } else {
            cur.isBST = false;
        }
        if (cur.isBST) {
            sol.ans = Math.max(sol.ans, cur.size);
        }
        return cur;
    }
    
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        Sol sol = new Sol();
        rec(root, sol);
        return sol.ans;
    }
}