/**
 * A Simple QuickSort Algorithm.
 * 
 * It seperates the array into two partitions using a pivot, 
 * sorts these two partitions by recursive partitioning and sorting, 
 * and it will result in a new sorted array.
 * 
 * @author seanlowjk 
 */
public class QuickSort {

    /**
     * The QuickSort Algorithm. 
     * 
     * It partitions the array given left and right bounds into two sections. 
     * Following which, based on the pivot retrieved, divides the problem 
     * into two smaller sub-problems and sorts them recursively. 
     * Do note that extra space is needed due to partitioning. 
     * Worst Time Complexity: O(n log n)
     * Best Time Complexity: O(n log n)
     * Space Complexity: O(log n) 
     * @param arr the array to be sorted. 
     * @param i the left bound of the array.
     * @param j the right bound of the array. 
     */
    public void sort(int[] arr, int i, int j) {
        if (i < j) {
            int pivot = partition(arr, i, j);
            sort(arr, i, pivot - 1);
            sort(arr, pivot + 1, j);
        }
    }

    /**
     * The Partition Algorithm.
     * 
     * This is not a stable algorithm. It sets the pivot as the 
     * left bound element of the array, then pushes elements
     * greater or equal to it onto the right side of the pivot
     * while elements lesser than it onto the left side
     * of the pivot via swapping. 
     */
    public int partition(int[] arr, int i, int j) {
        int p = arr[i];
        int m = i;
        for (int k = i + 1; k <= j; k ++) {
            if (arr[k] < p) {
                m ++;
                swap(arr, k, m); 
            }
        }
        swap(arr, i, m); 
        return m;
    }

    /**
     * The Partition Algorithm which is stable. 
     *
     * Instead of swapping elements, it shift the elements
     * to their desired positions. 
     */
    public int stablePartition(int[] arr, int i, int j) {
        int p = arr[i];
        int m = i;
        for (int k = i + 1; k <= j; k ++) {
            if (arr[k] < p) {
                m ++;
                swap(arr, k, m); 
            }
        }
        swap(arr, i, m); 
        return m;
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
