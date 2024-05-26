import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    private int leftChild(int parentIdx) {
        return 2 * parentIdx;
    }

    private int rightChild(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    private int parentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private void swap(int idx1, int idx2) {
        int temp = this.heap.get(idx1);

        this.heap.set(idx1, heap.get(idx2));
        this.heap.set(idx2, temp);
    }

    public List<Integer> getHeap() { // return copy of existing heap
        return new ArrayList<>(heap);
    }

}
