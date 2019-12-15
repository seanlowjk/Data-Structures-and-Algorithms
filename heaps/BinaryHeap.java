
import java.util.ArrayList;
import java.util.List;

/**
 * Represents A Binary Heap, which implements a Max-Heap Structure. 
 * 
 * The Underlying Data Structure can be an Array or an ArrayList. It stores 
 * the number of nodes in it as a size. All indices of nodes are one-indexed. 
 * 
 * @author seanlowjk
 * 
 */
public class BinaryHeap<T extends Comparable<T>> {

    /**
     * The Underlying Data Structure to stores the nodes. 
     */
    private ArrayList<T> nodes;

    /**
     * The Size of the Binary Heap. 
     */
    private int BinaryHeapSize;

    /**
     * Constructus a Simple Binary Heap. 
     */
    public BinaryHeap() {
        nodes = new ArrayList<>();
        nodes.add(null); 
        BinaryHeapSize = 0;
    }
  
    /**
     * Constructs a Simple Binary Heap using an input array.
     * @param array the input array. 
     */
    public BinaryHeap(T[] array) {
        CreateHeap(array);
    }

    /**
     * Gets the parent index of the node with index i.
     * @param i the index of the node.
     * @return the parent index. 
     */
    public int parent(int i) {
        return i / 2;
    } 

    /**
     * Gets the left child index of the node with index i.
     * @param i the index of the node.
     * @return the left child index. 
     */
    public int left(int i) {
        return i * 2;
    } 

    /**
     * Gets the right child index of the node with index i.
     * @param i the index of the node.
     * @return the right child index. 
     */
    public int right(int i) {
        return (i * 2) + 1;
    }

    /**
     * Gets all the nodes in the Binary Heap.
     * @return the nodes as an ArrayList. 
     */
    public ArrayList<T> getNodes() {
        return this.nodes;
    }

    /**
     * A Simple Algorithm to shift up the node at the specified index. 
     * 
     * This is done to maintain the Max-Heap Structure. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param i the index of the node to be shifted. 
     */
    private void shiftUp(int i) {
        while (i > 1 && nodes.get(parent(i)).compareTo(nodes.get(i)) < 0) {
            T temp = nodes.get(i);
            nodes.set(i, nodes.get(parent(i)));
            nodes.set(parent(i), temp);
            i = parent(i);
        }
    }

    /**
     * A Simple Algorithm to insert a value into the Binary Heap.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param key the element to be added. 
     */
    public void Insert(T key) {
        BinaryHeapSize++;
        if (BinaryHeapSize >= nodes.size()) {
            nodes.add(key);
            shiftUp(BinaryHeapSize);
        } else {
            nodes.set(BinaryHeapSize, key);
            shiftUp(BinaryHeapSize);
        }
    }

    /**
     * A Simple Algorithm to shift down the node at the specified index. 
     * 
     * This is done to maintain the Max-Heap Structure. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param i the index of the node to be shifted. 
     */
    private void shiftDown(int i) {
        while (i <= BinaryHeapSize) {
            T maxV = nodes.get(1);    
            int max_id = i;

            if (left(i) <= BinaryHeapSize && maxV.compareTo(nodes.get(left(i))) < 0) { 
                maxV = nodes.get(left(i));
                max_id = left(i);
            }
            
            if (right(i) <= BinaryHeapSize && maxV.compareTo(nodes.get(right(i))) < 0) {
                maxV = nodes.get(right(i)); 
                max_id = right(i);
            }

            if (max_id != i) {
                T temp = nodes.get(i);
                nodes.set(i, nodes.get(max_id));
                nodes.set(max_id, temp);
                i = max_id;
            } else {
                break;
            }
        }
    }

    /**
     * A Simple Algorithm to extract the largest value at the top of the Binary Heap. 
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @return the maximum value of the Binary Heap.
     */
    public T ExtractMax() {
        T maxV = nodes.get(1);    

        nodes.set(1, nodes.get(BinaryHeapSize));
        BinaryHeapSize--; 
        shiftDown(1);

        return maxV;
    }

    /**
     * An Expensive Algorithm to create a Binary Heap using an array.
     * 
     * This is done by adding every single element into the Binary Heap.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * @param arr the array which makes up the Binary Heap.
     */
    public void CreateHeapSlow(T[] arr) { 
        nodes = new ArrayList<T>();
        nodes.add(null); 
        for (int i = 1; i <= arr.length; i++) {
            Insert(arr[i-1]);
        }
    }

    /**
     * An Cheaper Algorithm to create a Binary Heap using an array.
     * 
     * This is done by adding all elements and then shifting the structure. 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param arr the array which makes up the Binary Heap.
     */
    public void CreateHeap(T[] arr) { 
        BinaryHeapSize = arr.length;
        nodes = new ArrayList<T>();
        nodes.add(null);
        for (int i = 1; i <= BinaryHeapSize; i++) {
            nodes.add(arr[i-1]);
        }

        for (int i = parent(BinaryHeapSize); i >= 1; i--) {
            shiftDown(i);
        }
    }

    /**
     * A Simple Algorithm which takes in an array and sorts it.
     * 
     * This is done by adding all elemenets and extracting 
     * the values one by one. 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * @param arr the input array.
     * @return the sorted array. 
     */
    public T[] HeapSort(T[] arr) { 
        CreateHeap(arr);
        int N = arr.length;
        for (int i = 1; i <= N; i++) {
            nodes.set(N-i+1, ExtractMax());
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[N];
        return nodes.toArray(result); 
    }

    /**
     * Gets the size of the Binary Heap.
     * @return the number of nodes in the Binary Heap.
     */
    public int size() {
        return BinaryHeapSize;
    }

    /**
     * Checks if the Binary Heap is empty or not.
     * @return true if the Binary Heap has 0 nodes. False if otherwise. 
     */
    public boolean isEmpty() {
        return BinaryHeapSize == 0;
    }

    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= BinaryHeapSize; i++) {
            sb.append(nodes.get(i) + " ");
        }
        return sb.toString();
    }
}
