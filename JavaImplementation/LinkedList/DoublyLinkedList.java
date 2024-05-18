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

    public void append(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0) return null;
        Node temp = this.tail;
        if (length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.head.prev = null;
        this.length--;

        if (this.length == 0) { // only 1 element exist previously
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public Node get(int idx) {
        if (idx < 0 || idx >= this.length) return null;
        Node temp = this.head;

        if (idx < this.length / 2) {
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length - 1; i > idx; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int idx, int val) {
        if (idx < 0 || idx >= this.length) return false;

        Node temp = this.get(idx);
        if (temp != null) {
            temp.val = val;
            return true;
        }
        return false;
    }

    public boolean insert(int idx, int val) {
        if (idx < 0 || idx > this.length) return false;

        if (idx == 0) {
            this.prepend(val);
            return true;
        }
        if (idx == this.length) {
            this.append(val);
            return true;
        }
        Node newNode = new Node(val);
        Node prev = this.get(idx - 1);

        newNode.next = prev.next;
        newNode.prev = prev;
        prev.next = newNode;
        newNode.next.prev = newNode;
        this.length++;
        return true;
    }

    public Node remove(int idx) {
        if (idx < 0 || idx > this.length) return null;
        if (idx == 0) return this.removeFirst();
        if (idx == this.length) return this.removeLast();

        Node temp = get(idx);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        this.length--;
        return temp;
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
