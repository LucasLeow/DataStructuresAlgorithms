public class BinarySearchTree {
    private Node root; // need root pointer to point to first Node, else garbage collected
    class Node {
        int value;
        Node left;
        Node right;

        Node(int val) {
            this.value = val;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (this.root == null) {
            this.root = newNode;
            return true;
        }

        Node temp = this.root;
        while(temp != null) {
            if (value == temp.value) return false; // equal values not allowed in BST

            if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
        return false;
    }
}
