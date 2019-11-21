/**
 * Represents a Circular LinkedList based on the generice type T given.
 * 
 * Everytime you modify the Circular Linked List, you have to make it
 * back to become circular again.
 * 
 * @author seanlowjk
 */
public class CircularLinkedList<T> extends LinkedList<T> {

    /**
     * Constructs a Circular LinkedList with 0 elements.
     */
    public CircularLinkedList() {
        super(); 
    }

    /**
     * Ensures that the next pointer of the last element always
     * points back to the first element of the Circular LinkedList.
     * 
     * It always does one, constant operation. 
     * Time Complexity: O(1) 
     * Space Complexity: O(1)
     */
    public void makeCircular() {
        if (tail != null) {
            tail.next = head;
        }
    }

    @Override
    public void addFirst(T val) {
        super.addFirst(val);
        makeCircular();
    }

    @Override
    public void addLast(T val) {
        super.addLast(val);
        makeCircular();
    }

    @Override
    public void addBefore(ListNode<T> node, T val) {
        super.addBefore(node, val);
        makeCircular();
    }

    @Override
    public void addAfter(ListNode<T> node, T val) {
        super.addAfter(node, val);
        makeCircular();
    }

    @Override
    public void add(int index, T val) {
        super.add(index, val);
        makeCircular();
    }

    @Override
    public T removeFirst() {
        T element = super.removeFirst();
        makeCircular();
        return element;
    }

    @Override
    public T removeLast() {
        T element = super.removeLast();
        makeCircular();
        return element;
    }

    @Override
    public T removeBefore(ListNode<T> node) {
        T element = super.removeBefore(node);
        makeCircular();
        return element;
    }

    @Override
    public T removeAfter(ListNode<T> node) {
        T element = super.removeAfter(node);
        makeCircular();
        return element;
    }

    @Override
    public T remove(int index) {
        T element = super.remove(index);
        makeCircular();
        return element;
    }

}
