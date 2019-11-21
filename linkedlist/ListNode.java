/**
 * Represents a Simple ListNode. 
 * 
 * It has two reference pointers to the next ListNode and to the previous 
 * ListNode, and stores a value based on the Generic Type T given.
 * 
 * @author seanlowjk 
 */ 
public class ListNode<T> {

    /**
     * Stores the value of the ListNode.
     */ 
    public T val;

    /**
     * Stores the pointer to the previous ListNode.
     */ 
    public ListNode<T> prev;

    /**
     * Stores the pointer to the next ListNode.
     */ 
    public ListNode<T> next;

    /**
     * Constructs a new ListNode based on the value given.
     * 
     * @param val the value provided.
     */
    public ListNode(T val) {
        this.val = val;
    }

    /**
     * Constructs a new ListNode based on the value given, the previous and next ListNode.
     * 
     * @param val the value provided.
     * @param prev the previous ListNode.
     * @param next the next listNode.
     */
    public ListNode(T val, ListNode<T> prev, ListNode<T> next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListNode) {
            ListNode other = (ListNode) obj;
            return (this.val.equals(other.val)) 
                && (this.prev == other.prev || this.prev.equals(other.prev))
                && (this.next == other.next || this.next.equals(other.next));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return val + "";
    }
}
