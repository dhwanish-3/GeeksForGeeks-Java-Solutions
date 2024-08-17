// class Node
// {
//     int data;
//     Node left;
//     Node right;
//     int height;
// };

// class Solution
// {
//     int height(Node node)
//     {
//         if(node == null) {
//             return 0;
//         }
//         return node.height;
//     }
//     int getBalance(Node node)
//     {
//         if(node == null) {
//             return 0;
//         }
//         return height(node.left) - height(node.right);
//     }
//     Node rightRotate(Node node)
//     {
//         Node left = node.left;
//         Node leftRight = left.right;
//         left.right = node;
//         node.left = leftRight;
//         node.height = 1 + Math.max(height(node.left), height(node.right));
//         left.height = 1 + Math.max(height(left.left), height(left.right));
//         return left;
//     }
//     Node leftRotate(Node node)
//     {
//         Node right = node.right;
//         Node rightLeft = right.left;
//         right.left = node;
//         node.right = rightLeft;
//         node.height = 1 + Math.max(height(node.left), height(node.right));
//         right.height = 1 + Math.max(height(right.left), height(right.right));
//         return right;
//     }
//     public Node insertToAVL(Node node, int data)
//     {
//         if(node == null) {
//             Node newNode = new Node(data);
//             newNode.data = data;
//             newNode.left = null;
//             newNode.right = null;
//             newNode.height = 1;
//             return newNode;
//         }
//         if(data < node.data) {
//             node.left = insertToAVL(node.left, data);
//         } else if(data > node.data) {
//             node.right = insertToAVL(node.right, data);
//         } else {
//             return node;
//         }
//         node.height = 1 + Math.max(height(node.left), height(node.right));
//         int balance = getBalance(node);
//         if(balance > 1 && data < node.left.data) {
//             return rightRotate(node);
//         }
//         if(balance < -1 && data > node.right.data) {
//             return leftRotate(node);
//         }
//         if(balance > 1 && data > node.left.data) {
//             node.left = leftRotate(node.left);
//             return rightRotate(node);
//         }
//         if(balance < -1 && data < node.right.data) {
//             node.right = rightRotate(node.right);
//             return leftRotate(node);
//         }
//         return node;
//     }
// }


/**
 * AVL Tree Insertion
 */
public class Node {
    int data;
    int height;
    Node left, right;
    public Node(int val, int h) {
        this.data = val;
        this.height = h;
        this.left = this.right = null;
    }
    public Node(int val, int h, Node l, Node r) {
        this.data = val;
        this.height = h;
        this.left = l;
        this.right = r;
    }
}
public class AVLTree {
    Node root;
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }
    private int getBalance(Node node) {
        return getHeight(node.left) - getHeight(node.right);
    }
    private Node rightRotate(Node node) {
        Node left = node.left;
        Node lr = left.right;
        node.left = lr;
        left.right = node;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        left.height = 1 + Math.max(getHeight(left.left), getHeight(left.right));
        return left;
    }
    private Node leftRotate(Node node) {
        Node right = node.right;
        Node rl = right.left;
        node.right = rl;
        right.left = node;
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        right.height = 1 + Math.max(getHeight(right.left), getHeight(right.right));
        return right;
    }
    private Node insert(Node node, int data) {
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int bal = getBalance(node);
        if (bal > 1) {
            if (data < node.left.data) {
                return rightRotate(node);
            } else if (data > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (bal < -1) {
            if (data > node.right.data) {
                return leftRotate(node);
            } else if (data < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    public void insert(int data) {
        if (root == null) {
            Node node = new Node(data, 1);
            return;
        }
        insert(root, data);
    }
}