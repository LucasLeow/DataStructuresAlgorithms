public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }
    public void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
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

    public static void main(String[] args) {
            System.out.println("hello, world");
    }
}
