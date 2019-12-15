/**
 * Represents Am AVL Tree. 
 * 
 * There is no underlying data sturcture. What it does it to ensure that
 * the items on the left are smaller than the root and the 
 * itmes on the right are larger than the root. 
 * Do note that this Binary Search Tree is for integers >= 0. 
 * 
 * Another thing to note that the height of a vertex's left subtree
 * differs from its right subtree by at most only 1 and vice versa. 
 * 
 * @author seanlowjk
 * 
 */
public class AVL {

    
    /**
     * The root vertex of the AVL Tree.
     */
    public AVLVertex root;

    /**
     * Constructs a Simple AVL Tree. 
     */
    public AVL() {
        root = null;
    }

    /**
     * Algorithm covered in BST.java 
     */
    public boolean search(int v) {
        AVLVertex result = search(root, v);
        return result != null;
    }

    /**
     * Algorithm covered in BST.java 
     */
    private AVLVertex search(AVLVertex T, int v) {
        if (T == null) {
            return null;
        } else if (T.key == v) {
            return T;
        } else if (T.key < v) {
            return search(T.right, v);
        } else {
            return search(T.left, v);
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    public int findMin() { 
        return findMin(root);
    }
    
    /**
     * Algorithm covered in BST.java 
     */
    private int findMin(AVLVertex T) {
        if (T.left == null) {
            return T.key;
        } else {
            return findMin(T.left);
        }                
    }

    /**
     * Algorithm covered in BST.java 
     */
    public int findMax() {
        return findMax(root);
    }
    
    /**
     * Algorithm covered in BST.java 
     */
    private int findMax(AVLVertex T) {
        if (T.right == null) {
            return T.key;
        } else {
            return findMax(T.right);
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    public int successor(int v) { 
        AVLVertex vPos = search(root, v);
        if (vPos == null) {
            return -1;
        } else {
            return successor(vPos);
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    private int successor(AVLVertex T) {
        if (T.right != null) {                      
            return findMin(T.right); 
        } else {
            AVLVertex paren = T.parent;
            AVLVertex curr = T;
            while ((paren != null) && (curr == paren.right)) {
                curr = paren;                                         
                paren = curr.parent;
            }
            if (paren == null) {
                return -1;
            } else {
                return paren.key;
            }
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    public int predecessor(int v) { 
        AVLVertex vPos = search(root, v);
        if (vPos == null) {
            return -1;
        } else {
            return predecessor(vPos);
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    private int predecessor(AVLVertex T) {
        if (T.left != null) {                         
            return findMax(T.left);  
        } else {
            AVLVertex paren = T.parent;
            AVLVertex curr = T;
            while ((paren != null) && (curr == paren.left)) { 
                curr = paren;                                         
                paren = curr.parent;
            }
            if (paren == null) {
                return -1;
            } else {
                return paren.key;
            }
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    public void preorder() { 
        preorder(root);
        System.out.println();
    }

    /**
     * Algorithm covered in BST.java 
     */
    private void preorder(AVLVertex T) {
        if (T == null) {
            return;
        } 
        System.out.printf("%d ", T.key);                     
        preorder(T.left);                            
        preorder(T.right);                            
    }

    /**
     * Algorithm covered in BST.java 
     */
    public void inorder() { 
        inorder(root);
        System.out.println();
    }

    /**
     * Algorithm covered in BST.java 
     */
    private void inorder(AVLVertex T) {
        if (T == null) {
            return;
        } 
        inorder(T.left);                            
        System.out.printf("%d ", T.key);                     
        inorder(T.right);                            
    }

    /**
     * Algorithm covered in BST.java 
     */
    public void postorder() { 
        postorder(root);
        System.out.println();
    }

    /**
     * Algorithm covered in BST.java 
     */
    private void postorder(AVLVertex T) {
        if (T == null) {
            return;
        } 
        postorder(T.left);                            
        postorder(T.right);                            
        System.out.printf("%d ", T.key);                     
    }

    /**
     * Calculates the balance facotr of the AVL Vertex. 
     * 
     * This can be done using the height of left sub-tree
     * minus the height of the right sub-tree. 
     * @param T the AVL Vertex to be looked at. 
     * @return the balance factor as an integer. 
     */
    private int balanceFactor(AVLVertex T) {
        if (T == null) {
            return 0;
        }

        return getHeight(T.left) - getHeight(T.right);
    }

    /**
     * Balances the left subtree, right subtree and the Vertex, if needed. 
     * 
     * This is done by calculating the balance factor of the AVL Vertex 
     * and rotating the AVL Vertex in a certain orientation. 
     * @param T the AVL Vertex to be looked at. 
     * @return the AVL Vertex after balancing. 
     */
    private AVLVertex balance(AVLVertex T) {
        int balance = balanceFactor(T);
        int balanceLeft = balanceFactor(T.left);
        int balanceRight = balanceFactor(T.right);

        if (balance == 2 && balanceLeft >= 0 && balanceLeft <= 1) {
            return rotateRight(T);
        }

        if (balance == -2 && balanceRight >= -1 && balanceRight <= 0) {
            return rotateLeft(T);
        }

        if (balance == 2 && balanceLeft == -1) {
            T.left = rotateLeft(T.left);
            return rotateRight(T);
        }

        if (balance == -2 && balanceRight == 1) {
            T.right = rotateRight(T.right);
            return rotateLeft(T);
        }

        return T;                                         
    }

    private AVLVertex rotateRight(AVLVertex T) {
        AVLVertex w = T.left;
        w.parent = T.parent;
        T.parent = w;
        T.left = w.right;
        if (w.right != null) {
            w.right.parent = T;
        }
        w.right = T;
        w.size = T.size;
        T.size = getSize(T);
        T.height = getHeight(T);
        w.height = T.height + 1;
        return w;
    }

    private AVLVertex rotateLeft(AVLVertex T) {
        AVLVertex w = T.right;
        w.parent = T.parent;
        T.parent = w;
        T.right = w.left;
        if (w.left != null) {
            w.left.parent = T;
        }
        w.left = T;
        w.size = T.size;
        T.size = getSize(T);
        T.height = getHeight(T);
        w.height = T.height + 1;
        return w;
    }

    /**
     * Inserts a value into the AVL Tree. 
     * @param v the value to be inserted. 
     */
    public void insert(int v) {
        root = insert(root, v);
    }

    /**
     * Inserts a value into the AVL Tree. 
     * 
     * Note that re-balancing may be needed after insertion. 
     * Time Complexity: O(log n)
     * @param T the AVL Vertex to be checked. 
     * @param v the value to be inserted. 
     * @return the AVL Vertex after insertion. 
     */
    private AVLVertex insert(AVLVertex T, int v) {
        if (T == null) return new AVLVertex(v);         

        if (T.key < v) {                                     
            T.right = insert(T.right, v);
            T.right.parent = T;
        }
        else {                                                
            T.left = insert(T.left, v);
            T.left.parent = T;
        }

        T.height = getHeight(T);
        T.size = getSize(T);

        return balance(T);
    }  

    /**
     * Delets a value from the AVL Tree, if present. 
     * @param v the value to be deleted. 
     */
    public void delete(int v) { 
        root = delete(root, v);
    }

    /**
     * Deletes a value from the AVL Tree. 
     * 
     * Note that re-balancing may be needed after deletion. 
     * Time Complexity: O(log n)
     * @param T the AVL Vertex to be checked. 
     * @param v the value to be deleted. 
     * @return the AVL Vertex after deletion. 
     */
    private AVLVertex delete(AVLVertex T, int v) {
        if (T == null)  return T;              

        if (T.key < v) {                                    
            T.right = delete(T.right, v);
        } else if (T.key > v) {                             
            T.left = delete(T.left, v);
        } else {                                            
            if (T.left == null && T.right == null) {                   
                T = null;                                     
            } else if (T.left == null && T.right != null) {   
                T.right.parent = T.parent;
                T = T.right;                                               
            } else if (T.left != null && T.right == null) {    
                T.left.parent = T.parent;
                T = T.left;
            } else {                               
                int successorV = successor(v);
                T.key = successorV;        
                T.right = delete(T.right, successorV);      
            }
        }

        if (T != null) {
            T.height = getHeight(T);
            T.size = getSize(T);
            return balance(T);
        } else {
            return null;
        }
    }

    /**
     * Algorithm covered in BST.java 
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * Algorithm covered in BST.java 
     */
    private int getHeight(AVLVertex T) {
        if (T == null) {
            return -1;
        }

        if (T.right != null && T.left != null) {
            return Math.max(T.left.height, T.right.height) + 1;
        } else if (T.right != null) {
            return T.right.height + 1;
        } else if (T.left != null) {
            return T.left.height + 1;
        } else {
            return 0;
        }
    }

    /**
     * Gets the size of the entire AVL Tree. 
     * Time Complexity: O(n)
     * @return the size as an integer. 
     */
    public int getSize() {
        return getSize(root);
    }

    /**
     * Gets the size of the current AVL Vertex.
     * @param T the AVL Vertex to be looked at. 
     * @return the size as an integer. 
     */
    private int getSize(AVLVertex T) {
        if (T == null) {
            return 0;
        }

        if (T.right != null && T.left != null) {
            return T.left.size + T.right.size + 1;
        } else if (T.right != null) {
            return T.right.size + 1;
        } else if (T.left != null) {
            return T.left.size + 1;
        } else {
            return 1;
        }
    }

    /**
     * Gets the rank of the value entered. 
     * Rank refers to the number of vertices with values <= v
     * Time Complexity: O(n)
     * @param v the value to be looked at. 
     * @return the rank as an integer. 
     */
    public int getRank(int v) {
        return getRank(v, root);
    }

    /**
     * Gets the rank of the value entered, in comparison to the current AVL Vertex. 
     * @param v the value to be looked at. 
     * @param T the AVL Vertex to be looked at. 
     * @return the rank as an integer. 
     */
    private int getRank(int v, AVLVertex T) {
        if (T == null) {
            return 0;
        }

        if (v < T.key) {
            return getRank(v, T.left);
        } else if (v > T.key) {
            return 1 + getSize(T.left) + getRank(v, T.right);
        } else {
            return 1 + getSize(T.left);
        }
    }
}

/**
 * Represents a Simple Vertex in the AVL Tree. 
 */
class AVLVertex {

    /**
     * The value of the Vertex. 
     */
    public int key;

    /**
     * The height of the vertex.
     */
    public int height;

    /**
     * The size of the vertex. 
     * This represents the number of vertexs in the left and right subtree + 1. 
     */
    public int size;

    /**
     * The parent, if any. 
     */
    public AVLVertex parent;

    /**
     * The left child, if any. 
     */
    public AVLVertex left;

    /**
     * The right child, if any. 
     */
    public AVLVertex right;

    public AVLVertex(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.size = 1;
    } 
}


