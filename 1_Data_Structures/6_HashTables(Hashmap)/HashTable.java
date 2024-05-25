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

    private int hashFunction(String key) {
        int hash = 0;

        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i]; // saving char as int will convert it to ascii equivalent value
            hash = (hash + asciiValue * 23) % dataMap.length; // 23 is random prime no., resulting in more random number
            // % dataMap.length will give range between 0 and (length of Array - 1)
        }
        return hash;
    }

    public void set(String key, int val) {
        Node newNode = new Node(key, val);
        int idx = this.hashFunction(key);

        if (this.dataMap[idx] == null) {
            this.dataMap[idx] = newNode;
        } else {
            Node temp = this.dataMap[idx];

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }

    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + " : ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("{" + temp.key + ":" + temp.value + "} ");
                temp = temp.next;
            }
        }
    }
}
