public class BinarySearchTree {
    Node root; // need root pointer to point to first Node, else garbage collected
    // cannot be private, else cannot be used by other class
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

    public boolean contains(int value) {
        if (this.root == null) return false;

        Node temp = this.root;

        while(temp != null) {
            if (temp.value == value) return true;

            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }
 }