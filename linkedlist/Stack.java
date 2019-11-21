/**
 * Represents a simple Stack Class.
 * 
 * Note that the underlying implementation is of a LinkedList.
 * It is of LIFO structure, where the last element inserted will be
 * the first element removed out of the Stack.
 * 
 * @author seanlowjk
 */
public class Stack<T> extends LinkedList<T> implements StackADT<T> {

    /**
     * Constructs an empty Stack with 0 elements in it.
     */
    public Stack() {
        super();
    }

    @Override
    public int size() {
        return super.size();
    } 

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(T val) {
        return super.contains(val);
    }

    @Override
    public T peek() {
        return super.getFirst();  
    }

    @Override
    public void push(T val) {
        super.addLast(val);
    }

    @Override
    public T pop() {
        return super.removeLast();
    }
}
