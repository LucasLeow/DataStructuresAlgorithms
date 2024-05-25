public class Stack {
    private Node top;
    private int height;

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.height = 1;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.height++;
    }

    public Node pop() {
        if (this.top == null) return null;

        Node temp = this.top;
        this.top = this.top.next;
        temp.next = null;
        this.height--;

        return temp;
    }

    public void printStack() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + this.top.val);
    }

    public void getHeight() {
        System.out.println("Height: " + this.height);
    }

    public static void main(String[] args) {

    }
}
