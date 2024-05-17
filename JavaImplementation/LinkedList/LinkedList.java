public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public LinkedList(int val) {
        Node newNode = new Node(val);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }
    public void append(int val) {
        // create new node + add node to end
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if (this.head == null) return null; // initial empty LL

        Node cur = this.head;
        Node pre = this.head;

        while(cur.next != null) {
            pre = cur;
            cur = cur.next;
        }

        this.tail = pre;
        pre.next = null;
        this.length--;

        if (this.length == 0) { // Initial LL only 1 element edge case
            this.head = null;
            this.tail = null;
        }
        return cur;
    }

    public void prepend(int val) {
        // create new node + add node to front
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }
    public boolean insert(int idx, int val) {
        // create new node + insert at index
    }
    public void printList() {
        Node cur = head;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + this.head.val);
    }

    public void getTail() {
        System.out.println("Tail: " + this.tail.val);
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }
}
