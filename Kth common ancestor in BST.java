import java.util.ArrayList;

class Solution {
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        Node cur = root;
        ArrayList<Integer> arr = new ArrayList<>();
        while (cur != null) {
            if (cur.data < x && cur.data < y) {
                arr.add(cur.data);
                cur = cur.right;
            } else if (cur.data > x && cur.data > y) {
                arr.add(cur.data);
                cur = cur.left;
            } else {
                arr.add(cur.data);   
                break;
            }
        }
        if (k <= arr.size()) {
            return arr.get(arr.size() - k);
        } else return -1;
        
    }
}