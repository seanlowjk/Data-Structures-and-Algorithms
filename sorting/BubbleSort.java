/**
 * A BubbleSort Sorting Algorithm. 
 * 
 * What it does is that it swaps elements such that at every iteration, 
 * the largest element will be at the end of the array. 
 * There is no need for an extra array, as this algorithm sorts 
 * elements within the given array itself. 
 * 
 * @author seanlowjk
 */
public class BubbleSort {

    /**
     * The normal version of BubbleSort. 
     * 
     * Worst Time Complexity: O(n^2)
     * Best Time Complexity: O(n^2)
     * Space Complexity: O(1) 
     * @param arr the array to be sorted.
     */
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            for (int j = 0; j < arr.length - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * The improved version of BubbleSort. 
     * Adds a flag in the event that there are no swaps
     * during any iteration of scanning through the array, 
     * there is no more need for swapping and hence, the algorithm terminates.
     * 
     * Worst Time Complexity: O(n^2)
     * Best Time Complexity: O(n)
     * Space Complexity: O(1) 
     * @param arr the array to be sorted.
     */
    public void improvedsort(int[] arr) {
        for (int i = 1; i < arr.length; i ++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }

            if (isSorted) {
                return;
            }
        }
    }

    /**
     * A Simple Swap Algorithm, which swaps the elements of an array
     * with regards to the specified indices. 
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * @param arr the array where the elements are swapped.
     * @param i the first index.
     * @param j the second index.
     */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
