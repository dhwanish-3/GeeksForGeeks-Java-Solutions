class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

/*
 * Should return minimum distance between a and b
 * in a tree with given root
 */
class GfG {
    int sol = 0;

    private int lca(Node node, int a, int b) {
        if (node == null) {
            return 0;
        }
        int left = lca(node.left, a, b);
        int right = lca(node.right, a, b);
        if (node.data == a || node.data == a) {
            if (left > 0) {
                sol = left;
            } else if (right > 0) {
                sol = right;
            } else {
                return 1;
            }
        }
        if (left > 0 && right > 0) {
            sol = left + right;
        } else if (right != 0) {
            return right + 1;
        } else if (left != 0) {
            return left + 1;
        }
        return 0;
    }

    int findDist(Node root, int a, int b) {
        if (a == b) {
            return 0;
        }
        sol = 0;
        lca(root, a, b);
        return sol;
    }
}