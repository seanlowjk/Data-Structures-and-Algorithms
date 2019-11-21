/**
 * A Simple SelectionSort Algorithm.
 * 
 * During every iteration. it makes sures that the 
 * biggest element will be placed at the end of the array. 
 * 
 * @author seanlowjk
 */
public class SelectionSort {

    /**
     * The normal version of SelectionSort. 
     * 
     * At every iteration, places the biggest element 
     * to the back of the array. This is done by swapping
     * the biggest element with the last element. 
     * Worst Time Complexity: O(n^2)
     * Best Time Complexity: O(n^2)
     * Space Complexity: O(1) 
     * @param arr the array to be sorted. 
     */
    public void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i --) {
            int ind = i;
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[ind]) {
                    ind = j;
                }
            }
            swap(arr, ind, i); 
        } 
    }

    /**
     * The stable version of SelectionSort. 
     * 
     * At every iteration, places the biggest element 
     * to the back of the array. This is done by shifting 
     * the biggest element to the last index while the 
     * last element takes the original position of the 
     * biggest element. 
     * Worst Time Complexity: O(n^2)
     * Best Time Complexity: O(n^2)
     * Space Complexity: O(1) 
     * @param arr the array to be sorted. 
     */
    public void stableSort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i --) {
            int ind = i;
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[ind]) {
                    ind = j;
                }
            }
            shift(arr, ind, i); 
        } 
    }

    /**
     * A Simple Swap Algorithm.
     * 
     * This swaps the elements of an array
     * with regards to the specified indices. 
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

    /**
     * A Simple Shifting Algorithm.
     * 
     * This shift the element all elements from i to j - 1
     * by 1 index back, while the element at index j 
     * replaces the original element at index i.
     * @param arr the array where the elements are swapped.
     * @param i the first index.
     * @param j the second index. 
     */
    public void shift(int[] arr, int i, int j) {
        int temp = arr[i];
        for (int k = i; k < j; k ++) {
            arr[k] = arr[k + 1];
        }
        arr[j] = temp;
    }

}
