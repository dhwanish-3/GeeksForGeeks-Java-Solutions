class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class Solution {
    public int getCount(Node node, int bud)
    {
        if (node == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    if (level <= bud) {
                        count++;
                        bud -= level;
                    }
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return count;
    }
}