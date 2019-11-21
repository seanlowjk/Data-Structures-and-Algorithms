/**
 * Represents an interface which represents the Stack ADT.
 * 
 * It is of LIFO structure, where the last element inserted will be
 * the first element removed out of the Stack.
 * 
 * @author seanlowjk
 */
public interface StackADT<T> {

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
     * Checks if the Stack is empty.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return true if the Stack stores 0 elements, false if otherwise.
     */
    public boolean isEmpty();

    /**
     * Checks if the Stack contains a value or not.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param val the value to be found.
     * @return true if the value exists in the Stack. False if otherwise.
     */
    public boolean contains(T val);

    
    /**
     * Check the element at the top of the Stack.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the element at the top of the Stack.
     */
    public T peek();

    /**
     * Adds the value to the top of the Stack.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param val the element to be added. 
     */
    public void push(T val);

    /**
     * Removes the element at the top of the Stack and returns its value.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the element at the top of the Stack.
     */
    public T pop();

}
