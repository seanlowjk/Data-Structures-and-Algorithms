/**
 * Represents a LinkedList based on the generice type T given.
 * 
 * It contains a head and tail pointer. Not only that, it keeps 
 * track the number of items in the list, so that query of the 
 * size of the LinkedList becomes O(1) 
 * 
 * @author seanlowjk
 */
public class LinkedList<T> {

    /**
     * Represents the head pointer of the LinkedList, also known as
     * the first ListNode.
     */
    protected ListNode<T> head;

    /**
     * Represents the head pointer of the LinkedList, also known as
     * the last ListNode.
     */
    protected ListNode<T> tail;

    /**
     * Represents the number of ListNodes within the LinkedList.
     */
    protected int size;

    /**
     * Constructs a new empty LinkedList.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the number of ListNodes within this LinkedList.
     * 
     * The time complexity of this method is O(n) if the data structure
     * does not keep track of the number of items automatically. 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the number of ListNodes.
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks if the LinkedList is empty.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return true if the LinkedList stores 0 nodes, false if otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the value of the first ListNode in the linkedList.
     * 
     * If there is nothing in the head of the LinkedList, return null.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the value of the first ListNode.
     */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    /**
     * Gets the value of the last ListNode in the linkedList.
     * 
     * If there is nothing in the tail of the LinkedList, return null.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the value of the last ListNode.
     */
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.val;
    }

    /**
     * Gets the head ListNode in the LinkedList.
     * 
     * If there is nothing in the head of the LinkedList, return null.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the head ListNode.
     */
    public ListNode<T> getHead() {
        return this.head;
    }

    /**
     * Gets the last ListNode in the LinkedList.
     * 
     * If there is nothing in the tail of the LinkedList, return null.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the last ListNode.
     */
    public ListNode<T> getTail() {
        return this.tail;
    }

    /**
     * Adds a value to the front of the LinkedList.
     * 
     * If the list is originally empty, ensure that the 
     * element becomes the first node in the LinkedList. 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param val the value of the new ListNode.
     */
    public void addFirst(T val) {
        if (head == null) { 
            head = new ListNode<T>(val);
            tail = head;
            size ++;
            return;
        }

        ListNode<T> temp = new ListNode<T>(val);
        head.prev = temp;
        temp.next = head;
        head = temp;
        size ++;
    }

    /**
     * Adds a value to the back of the LinkedList.
     * 
     * If the list is originally empty, ensure that the 
     * element becomes the last node in the LinkedList. 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param val the value of the new ListNode.
     */
    public void addLast(T val) {
        if (head == null) { 
            head = new ListNode<T>(val);
            tail = head;
            size ++;
            return;
        }

        ListNode<T> temp = new ListNode<T>(val);
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
        size ++;
    }

    /**
     * Adds a value before a specific node in the LinkedList.
     * 
     * If the node is null, simply do not add the value.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param node the specified node in the LinkedList.
     * @param val the value of the new ListNode.
     */
    public void addBefore(ListNode<T> node, T val) {
        if (node == null) {
            return;
        }

        if (node.equals(head)) {
            addFirst(val);
        } else {
            ListNode<T> before = node.prev;
            ListNode<T> temp = new ListNode<T>(val, before, node);
            before.next = temp;
            node.prev = temp;
            size ++;
        }
    }

    /**
     * Adds a value after a specific node in the LinkedList.
     * 
     * If the node is null, simply do not add the value.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param node the specified node in the LinkedList.
     * @param val the value of the new ListNode.
     */
    public void addAfter(ListNode<T> node, T val) {
        if (node == null) {
            return;
        }

        if (node.equals(tail)) {
            addLast(val);
        } else {
            ListNode<T> after = node.next;
            ListNode<T> temp = new ListNode<T>(val, node, after);
            node.next = temp;
            after.prev = temp;
            size ++;
        }
    }

    /**
     * Adds a value before a specific index in the LinkedList.
     * 
     * If the index is out of bounds, do not add the value inside.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param index the specified index in the LinkedList. 
     * @param val the value of the new ListNode.
     */
    public void add(int index, T val) {
        if (index > size || index < 0) {
            return; 
        }

        if (index == size) {
            addLast(val);
            return;
        }

        if (index == 0) {
            addFirst(val);
            return;
        }

        int count = 1;
        ListNode<T> before = head;
        while (count != index) {
            before = before.next;
            count ++;
        }

        ListNode<T> after = before.next;
        ListNode<T> temp = new ListNode<T>(val, before, after);
        before.next = temp;
        after.prev = temp;
        size ++;
    }

    /**
     * Checks if a specific value exists in the LinkedList or not.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param val the value of the ListNode.
     * @return true if the value exists in the LinkedList. False if otherwise.
     */
    public boolean contains(T val) {
        for (ListNode<T> curr = head; curr != null; curr = curr.next) {
            if (curr.val.equals(val)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the first ListNode in the linkedList, and returns the value.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the value of the first ListNode in the LinkedList, if present.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            ListNode<T> sole = head;
            head = null;
            tail = null;
            size = 0;
            return sole.val;
        }

        ListNode<T> temp = head;
        ListNode<T> curr = head.next;
        curr.prev = null;
        head = curr;
        size--;
        return temp.val;
    }

    /**
     * Removes the last ListNode in the linkedList, and returns the value.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @return the value of the first ListNode in the LinkedList, if present.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (size == 1) {
            ListNode<T> sole = head;
            head = null;
            tail = null;
            size = 0;
            return sole.val;
        }

        ListNode<T> temp = tail;
        ListNode<T> curr = tail.prev;
        curr.next = null;
        tail = curr;
        size --;
        return temp.val;
    }

    /**
     * Removes the ListNode before a specified ListNode, and returns its value.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param node the specified ListNode.
     * @return the value of the removed ListNode.
     */
    public T removeBefore(ListNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.equals(head)) {
            return null;
        }

        if (node.equals(head.next)) {
            return removeFirst();
        } else {
            ListNode<T> temp = node.prev;
            ListNode<T> before = temp.prev;
            before.next = node;
            node.prev = before;
            size --;
            return temp.val;
        }
    }

    /**
     * Removes the ListNode after a specified ListNode, and returns its value.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param node the specified ListNode.
     * @return the value of the removed ListNode.
     */
    public T removeAfter(ListNode<T> node) {
        if (node == null) {
            return removeFirst();
        }

        if (node.equals(tail)) {
            return null;
        }

        if (node.equals(tail.prev)) {
            return removeLast();
        } else {
            ListNode<T> temp = node.next;
            ListNode<T> after = temp.next;
            after.prev = node;
            node.next = after;
            size --;
            return temp.val;
        }
    }

    /**
     * Removes the ListNode at a specified index and returns its value.
     * 
     * Returns null if the index is out of bounds.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param index the specified index.
     * @return the value of the removed ListNode.
     */
    public T remove(int index) {
        if (index >= size || index < 0) {
            return null; 
        }

        if (index == size - 1) {
            return removeLast();
        }

        if (index == 0) {
            return removeFirst();
        }

        int count = 1;
        ListNode<T> before = head;
        while (count != index) {
            before = before.next;
            count ++;
        }

        return removeAfter(before);
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("[");
        int count = 0;
        ListNode<T> curr = head;
        while (count != size) {
            if (count != 0) {
                list.append(", ");
            }

            list.append(curr.val);
            curr = curr.next;
            count ++;
        }
        list.append("]");
        return list.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList) {
            return this.getHead().equals(((LinkedList) obj).getHead());
        } else {
            return false;
        }
    }
}

