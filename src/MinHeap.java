public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    public MinHeap(){
       new MinHeap(capacity);
    }

    public MinHeap (int capacity) {
        if (capacity< 1) {
            throw new IllegalArgumentException("Capacity needs to be greater than 0");
        }
        int[] items = new int[capacity];
    }

    private int getLeftChildIndex(int parentIndex) { return  2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex) {return (childIndex -1) / 2;}

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) { return getRightChildIndex(index) <size;}
    private boolean hasParent(int index) {return getParentIndex(index) >= 0;}

    private int leftChild(int index) {return items[getLeftChildIndex(index)];}
    private int rightChild(int index) {return items[getRightChildIndex(index)];}
    private int parent(int index) {return items[getParentIndex(index)]}

}
