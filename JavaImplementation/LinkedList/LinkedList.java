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

    public Node removeFirst() {
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = temp.next;
        temp.next = null;
        this.length--;

        if (this.length == 0) {
            this.tail = null;
        }
        return temp;
    }

    public Node get(int idx) {
        if (idx < 0 || idx >= this.length) return null;
        Node cur = this.head;
        for(int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean set(int idx, int val) {
        Node desired = this.get(idx);
        if (desired != null) {
            desired.val = val;
            return true;
        }
        return false;
    }

    public boolean insert(int idx, int val) {
        if (this.get(idx) == null) return false;
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
        prev.next = newNode;
        this.length++;
        return true;
    }

    public Node remove(int idx) {
        if (this.get(idx) == null) return null;
        if (idx == 0) return this.removeFirst();
        if (idx == this.length) return this.removeLast();

        Node prev = this.get(idx - 1);
        Node temp = prev.next;

        prev.next = prev.next.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < this.length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
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
