public class HashTable {
    private int size = 7; // prime numbers result in fewer collisions
    private Node[] dataMap; // dataMap is an array of pointers to head Nodes (Linked List)

    class Node {
        private String key;
        private int value;
        private Node next;
        private Node prev;

        public Node(String k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    public HashTable() {
        this.dataMap = new Node[this.size];
    }
}
