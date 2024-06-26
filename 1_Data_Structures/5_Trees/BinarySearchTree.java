public class BinarySearchTree {
    Node root; // root pointer to first Node of tree
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

    // actual contains method using recursion (not exposed as API)
    private boolean rContains(Node currentNode, int value) {

        if (currentNode == null) return false; // tree initially empty or value does not exist in BST
        if (currentNode.value == value) return true; // base case

        if (value < currentNode.value) { // value lower than root, traverse left sub-tree
            return this.rContains(currentNode.left, value);
        } else { // value greater than root, traverse right sub-tree
            return this.rContains(currentNode.right, value); 
        }
    }

    // recursive contains method exposed as API for others to use (method overload)
    public boolean rContains(int value) {
        return rContains(this.root, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value); // base case, once reached left-most null, return a new Node

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value){ // have to put this condition to account for duplicate value
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode; // return node before new node or if duplicate value exist, then return currentNode
    }

    public void rInsert(int value) {
        if (this.root == null) this.root = new Node(value);
        rInsert(this.root, value);
    }

    public int minValue(Node currentNode) { // can pass any node to find min value for any subtree
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null; // value not in tree

        // traverse tree
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value); // traverse left of tree
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value); // traverse right of tree

        } else { // value found that is supposed to be deleted (4 conditions)
            // 4 conditions: leaf node | left subtree exist | right subtree exist | both subtree exists

            // leaf node instance
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }

            // right subtree exist only
            if (currentNode.left == null) {
                currentNode = currentNode.right; // replace currentNode with currentNode.right;
                return currentNode; // return replaced node back to currentNode.left in recursive call
            }
            
            // left subtree exist only
            if (currentNode.right == null) {
                currentNode = currentNode.left;
                return currentNode;
            }

            // left & right subtree exists
            int subTreeMinVal = minValue(currentNode.right);
            currentNode.value = subTreeMinVal;
            currentNode.right = deleteNode(currentNode.right, subTreeMinVal);
        }
        return currentNode; // to propagate back recursion chain
    }
    
    public void deleteNode(int value) { // method overloading
        deleteNode(this.root, value);
    }
 }
