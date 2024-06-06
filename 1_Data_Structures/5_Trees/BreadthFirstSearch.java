import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    Node root;
    class Node {
        int value;
        Node left;
        Node right;

        Node(int val) {
            this.value = val;
        }
    }
    public ArrayList<Integer> BFS() {

        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>(); // Linkedlist implementation of Queue structure
        ArrayList<Integer> results = new ArrayList<>();

        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }
}
