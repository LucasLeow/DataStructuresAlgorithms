import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    private int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    private int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private void swap(int idx1, int idx2) {
        int temp = this.heap.get(idx1);

        this.heap.set(idx1, heap.get(idx2));
        this.heap.set(idx2, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int curIdx = this.heap.size() - 1;

        while (curIdx > 0 && this.heap.get(curIdx) > this.heap.get(getParentIdx(curIdx))) {
            this.swap(curIdx, this.getParentIdx(curIdx));
            curIdx = this.getParentIdx((curIdx));
        }
    }

    public List<Integer> getHeap() { // return copy of existing heap
        return new ArrayList<>(heap);
    }

    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(99);
        myHeap.insert(26);
        myHeap.insert(34);
        myHeap.insert(67);

        System.out.println(myHeap.getHeap());
    }

}
