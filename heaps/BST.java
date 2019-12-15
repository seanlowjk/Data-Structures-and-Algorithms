/**
 * Represents A Binary Search Tree. 
 * 
 * There is no underlying data sturcture. What it does it to ensure that
 * the items on the left are smaller than the root and the 
 * itmes on the right are larger than the root. 
 * Do note that this Binary Search Tree is for integers >= 0. 
 * 
 * @author seanlowjk
 * 
 */
public class BST {

    /**
     * The root vertex of the Binary Search Tree.
     */
    public BSTVertex root;

    /**
     * Constructs a Simple Binary Search Tree. 
     */
    public BST() {
        this.root = null;
    }

    /**
     * Searches for the vertex in the Binary Search tree. 
     * 
     * Returns -1 if the vertex cannot be found.
     * @param v the value of the vertex. 
     * @return the value if found. Else, -1. 
     */
    public int search(int v) {
        BSTVertex result = search(root, v);
        if (result == null) {
            return -1;
        } else {
            return result.key;
        }
    }

    /**
     * Searches for the vertex in the Binary Search Tree. 
     * 
     * If the current vertex has the same value given, return 
     * the vertex itself. Else, use recursion. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param T the vertex to be compared to. 
     * @param v the value of the vertex. 
     * @return the vertex if found. 
     */
    private BSTVertex search(BSTVertex T, int v) {
        if (T == null) {
            return null;
        } else if (v > T.key) {
            return search(T.right, v);
        } else if (v < T.key) {
            return search(T.left, v);
        } else {
            return T;
        }
    }

    /**
     * Searches for the minimum value in the Binary Search Tree. 
     * 
     * @return the minimum value in the Binary Search Tree. 
     */
    public int findMin() {
        return findMin(root);
    }

    /**
     * Searches for the minimum value in the Binary Search Tree. 
     * 
     * If the current vertex does not have a left child, 
     * return the value of the vertex itself. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param T the vertex to look at. 
     * @return the minimum value, which is either the vertex or the left child's value. 
     */
    private int findMin(BSTVertex T) {
        if (T.left == null) {
            return T.key;
        } else {
            return findMin(T.left);
        }
    }

    /**
     * Searches for the maximum value in the Binary Search Tree. 
     * 
     * @return the maximum value in the Binary Search Tree. 
     */
    public int findMax() {
        return findMax(root);
    }

    /**
     * Searches for the maximum value in the Binary Search Tree. 
     * 
     * If the current vertex does not have a right child, 
     * return the value of the vertex itself. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param T the vertex to look at. 
     * @return the maximum value, which is either the vertex or the right child's value. 
     */
    private int findMax(BSTVertex T) {
        if (T.right == null) {
            return T.key;
        } else {
            return findMax(T.right);
        }
    }

    /**
     * Searches for the next value greater than the current value entered in. 
     * 
     * If there is no such successor, return -1. 
     * @param v the value to be entered in. 
     * @return the next value greater than the current value. 
     */
    public int successor(int v) {
        BSTVertex pos = search(root, v);
        if (pos == null) {
            return -1;
        } else {
            return successor(pos);
        }
    }

    /**
     * Searches for the next value greater than the value of the current BST Vertex. 
     * 
     * If there is no such successor, return -1. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param T the current BST Vertex. 
     * @return the next value greater than the value of the current BST Vertex. 
     */
    private int successor(BSTVertex T) {
        if (T.right != null) {
            return findMin(T.right);
        } else {
            BSTVertex parent = T.parent;
            BSTVertex curr = T;
            while ((parent != null) && (curr == parent.right)) {
                curr = parent;
                parent = curr.parent;
            }
            if (parent == null) {
                return -1;
            } else {
                return parent.key;
            }
        }
    }

    /**
     * Searches for the next value smaller than the current value entered in. 
     * 
     * If there is no such predecessor, return -1. 
     * @param v the value to be entered in. 
     * @return the next value smaller than the current value. 
     */
    public int predecessor(int v) {
        BSTVertex pos = search(root, v);
        if (pos == null) {
            return -1;
        } else {
            return predecessor(pos);
        }
    }

    /**
     * Searches for the next value smaller than the value of the current BST Vertex. 
     * 
     * If there is no such predecessor, return -1. 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param T the current BST Vertex. 
     * @return the next value smaller than the value of the current BST Vertex. 
     */
    private int predecessor(BSTVertex T) {
        if (T.left != null) {
            return findMax(T.right);
        } else {
            BSTVertex parent = T.parent;
            BSTVertex curr = T;
            while ((parent != null) && (curr == parent.left)) {
                curr = parent;
                parent = curr.parent;
            }
            if (parent == null) {
                return -1;
            } else {
                return parent.key;
            }
        }
    }

    /**
     * Prints out the vertices in the BST in pre-order fashion. 
     */
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    /**
     * Prints out the vertices in the BST in pre-order fashion. 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param T the current BST Vertex to be looked at. 
     */
    private void preorder(BSTVertex T) {
        if (T == null) {
            return;
        }

        System.out.print(T.key);
        System.out.print(" ");
        preorder(T.left);
        preorder(T.right);
    }

    /**
     * Prints out the vertices in the BST in in-order fashion. 
     */
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    /**
     * Prints out the vertices in the BST in in-order fashion. 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param T the current BST Vertex to be looked at. 
     */
    private void inorder(BSTVertex T) {
        if (T == null) {
            return;
        }

        inorder(T.left);
        System.out.print(T.key);
        System.out.print(" ");
        inorder(T.right);
    }

    /**
     * Prints out the vertices in the BST in post-order fashion. 
     */
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    /**
     * Prints out the vertices in the BST in post-order fashion. 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param T the current BST Vertex to be looked at. 
     */
    private void postorder(BSTVertex T) {
        if (T == null) {
            return;
        }

        postorder(T.left);
        postorder(T.right);
        System.out.print(T.key);
        System.out.print(" ");
    }

    /**
     * Inserts a value into the BST.
     * @param v the value to be inserted. 
     */
    public void insert(int v) {
        root = insert(root, v);
    }

    /**
     * Inserts a value into the BST. 
     * Time Complexity: O(log n)
     * @param T the BST Vertex to be checked. 
     * @param v the value to be inserted. 
     * @return the BST Vertex after insertion. 
     */
    private BSTVertex insert(BSTVertex T, int v) {
        if (T == null) {
            return new BSTVertex(v);
        }    

        if (v > T.key) {
            T.right = insert(T.right, v);
            T.right.parent = T;
        } else {
            T.left = insert(T.left, v);
            T.left.parent = T;
        }

        T.height = getHeight(T);

        return T;
    }

    /**
     * Delets a value from the BST, if present. 
     * @param v the value to be deleted. 
     */
    public void delete(int v) {
        root = delete(root, v);    
    }

    /**
     * Deletes a value from the BST. 
     * Time Complexity: O(log n)
     * @param T the BST Vertex to be checked. 
     * @param v the value to be deleted. 
     * @return the BST Vertex after deletion. 
     */
    private BSTVertex delete(BSTVertex T, int v) {
        if (T == null) {
            return T;
        }

        if (T.key < v) {
            T.right = delete(T.right, v);
        } else if (T.key > v) {
            T.left = delete(T.left, v);
        } else {
            if (T.left == null && T.right == null) {
                T = null;
            } else if (T.left == null) {
                T.right.parent = T.parent;
                T = T.right;
            } else if (T.right ==  null) {
                T.left.parent = T.parent;
                T = T.left;
            } else {
                int V = successor(v);
                T.key = V;
                T.right = delete(T.right, V);
            }
        }

        return T;
    }

    /**
     * Gets the height of the entire BST. 
     * @return the height as an integer. 
     */
    public int getHeight() {
        return getHeight(root);
    } 

    /**
     * Gets the height of the current BST Vertex.
     * @param T the current BST Vertex.
     * @return the height as an integer. 
     */
    private int getHeight(BSTVertex T) {
        if (T == null) {
            return -1;
        }

        if (T.left != null && T.left != null) {
            return Math.max(T.left.height, T.right.height) + 1;
        } else if (T.right != null) {
            return T.right.height + 1;
        } else if (T.left != null) {
            return T.left.height + 1;
        } else {
            return 0;
        }
    }
}

/**
 * Represents A Simple Vertex in the BST. 
 */
class BSTVertex {

    /**
     * The value of the Vertex. 
     */
    public int key;

    /**
     * The height of the vertex.
     */
    public int height;

    /**
     * The parent, if any. 
     */
    public BSTVertex parent;

    /**
     * The left child, if any. 
     */
    public BSTVertex left;

    /**
     * The right child, if any. 
     */
    public BSTVertex right;
    
    BSTVertex(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
    } 
}
