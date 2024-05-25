public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int val;
        Node next;

        public Node(int value) {
            this.val = value;
        }
    }

    public Queue(int val) {
        Node newNode = new Node(val);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
    }

    public Node dequeue() {
        if (this.length == 0) {
            return null;
        }

        Node temp = this.first;

        if (this.length == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            temp.next = null;
        }
        this.length--;
        return temp;
    }

    public void printQueue() {
        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void getFirst() {
        System.out.println("First: " + this.first.val);
    }
    public void getLast() {
        System.out.println("Last: " + this.last.val);
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }
}
