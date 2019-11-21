/**
 * Represents a simple Queue Class.
 * 
 * Note that the underlying implementation is of a LinkedList.
 * It is of FIFO structure, where the first element inserted will be
 * the first element removed out of the Queue.
 * 
 * @author seanlowjk
 */
public class Queue<T> extends LinkedList<T> implements QueueADT<T> {

    /**
     * Constructs an empty Queue with 0 elements in it.
     */
    public Queue() {
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
    public void offer(T val) {
        super.addLast(val);    
    }


    @Override
    public void add(T val) {
        offer(val);
    }


    @Override
    public void enqueue(T val) {
        offer(val);
    }


    @Override
    public T poll() {
        return super.removeFirst();
    }

    @Override
    public T enqueue() {
        return poll();
    }

}
