/**
 * Represents an interface which represents the Queue ADT.
 * 
 * It is of FIFO structure, where the first element inserted will be
 * the first element removed out of the Queue.
 * 
 * @author seanlowjk
 */
public interface QueueADT<T> {

    /**
     * Returns the number of ListNodes within this Queue.
     * 
     * The time complexity of this method is O(n) if the data structure
     * does not keep track of the number of items automatically. 
     * Time Complexity: O(1), 
     * Space Complexity: O(1)
     * @return the number of elements.
     */
    public int size();

    /**
     * Checks if the Queue is empty.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return true if the Queue stores 0 elements, false if otherwise.
     */
    public boolean isEmpty();

    /**
     * Checks if the Queue contains a value or not.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param val the value to be found.
     * @return true if the value exists in the Queue. False if otherwise.
     */
    public boolean contains(T val);

    /**
     * Check the element at the front of the Queue.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the element at the front of the Queue.
     */
    public T peek();

    /**
     * Adds an element to the back of the Queue.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param val the element to be added.
     */
    public void offer(T val);

    /**
     * Adds an element to the back of the Queue.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param val the element to be added.
     */
    public void add(T val);

    /**
     * Adds an element to the back of the Queue.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param val the element to be added.
     */
    public void enqueue(T val);

    /**
     * Removes the element at the front of the Queue.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the element removed.
     */
    public T poll();

    /**
     * Removes the element at the front of the Queue.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the element removed.
     */
    public T enqueue();
}

