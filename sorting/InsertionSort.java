/**
 * A Simple InsertionSort Algorithm. 
 *
 * For every iteration, it ensures that elements 
 * smaller than the key will be placed in front of the key. 
 * 
 * @author seanlowjk
 */
public class InsertionSort {

    /**
     * The InsertionSort Algorithm. 
     * 
     * For every iteration, it selects a key. 
     * After which, it shifts elements smaller than 
     * the key to the front of the key. 
     * Worst Time Complexity: O(n^2)
     * Best Time Complexity: O(n)
     * Space Complexity: O(1)  
     * @param arr the array to be sorted.
     */
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            int next = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > next; j --) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = next;
        }
    }
}
