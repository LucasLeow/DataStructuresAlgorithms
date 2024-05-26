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

    private void sinkDown(int idx) {
        int maxIdx = idx;
        while (true) {
            int leftChildIdx = this.getLeftChildIdx(maxIdx);
            int rightChildIdx = this.getRightChildIdx(maxIdx);

            // guard clause to ensure left branch of heap exist
            if (leftChildIdx < this.heap.size() && this.heap.get(leftChildIdx) > this.heap.get(maxIdx)) {
                maxIdx = leftChildIdx;
            }

            // guard clause to ensure right branch of heap exist
            // maxIdx pointer to leftChildIdx, so check if Right larger than Left
            if (rightChildIdx < this.heap.size() && this.heap.get(rightChildIdx) > this.heap.get(maxIdx)) {
                maxIdx = rightChildIdx;
            }

            if (maxIdx != idx) {
                this.swap(idx, maxIdx);
                idx = maxIdx;
            } else {
                return; // maxIdx == idx, i.e heap valid
            }
        }
    }

    public void insert(int value) {
        this.heap.add(value);
        int curIdx = this.heap.size() - 1;

        while (curIdx > 0 && this.heap.get(curIdx) > this.heap.get(getParentIdx(curIdx))) {
            this.swap(curIdx, this.getParentIdx(curIdx));
            curIdx = this.getParentIdx((curIdx));
        }
    }

    public Integer remove() {
        if (this.heap.size() == 0) return null;

        if (this.heap.size() == 1) {
            return this.heap.remove(0);
        }

        // Swap root node & cornermost node
        this.swap(0, this.heap.size() - 1);

        // Remove last node from heap
        int maxValue = this.heap.remove(this.heap.size() - 1);

        // Sink node if needed
        this.sinkDown(0);
        return maxValue;
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
