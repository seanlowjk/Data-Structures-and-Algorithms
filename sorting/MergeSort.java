/**
 * A Simple Merge Sort Algorithm 
 * 
 * Divides the problem into two smaller subproblems. 
 * Following which, sorts these two smaller subproblems and 
 * merges them back together recursively. 
 * 
 * @author seanlowjk
 */
public class MergeSort {

    /**
     * The MergeSort Algorithm.
     * 
     * Gets the middle point to seperate the array into two
     * smaller subarrays, then recursively merge and sort. 
     * Note that this takes more space than usual, as you will be required 
     * to have copies of the sub arrays, based on the merge algorithm. 
     * Worst Time Complexity: O(n log n)
     * Best Time Complexity: O(n log n)
     * Space Complexity: O(n)  
     * @param arr the array to be sorted. 
     * @param i the left bound of the array. 
     * @param j the right bound of the array. 
     */
    public void sort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            sort(arr, i, mid);
            sort(arr, mid + 1, j);
            merge(arr, i, mid, j);
        }    
    }

    /**
     * The Merging Algorithm.
     * 
     * Assuming both sub-arrays are sorted. Merges them together in such 
     * a way that elements will be in order from smallest the biggest. 
     * Note that a temporary array is needed in order to store 
     * the new positiions of the elements of the two sub-arrays. 
     * @param arr the array to be sorted. 
     * @param i the left bound of the array.
     * @param mid the index which seperates the two sub-arrays.
     * @param j the right bound of the array. 
     */
    public void merge(int[] arr, int i, int mid, int j) {
        int[] temp = new int[j - i + 1];
        int left = i;
        int right = mid + 1;
        int ind = 0;
        while (left <= mid && right <= j) {
            if (arr[left] <= arr[right]) {
                temp[ind] = arr[left];
                ind ++;
                left ++;
            } else {
                temp[ind] = arr[right];
                ind ++;
                right ++;
            }
        }

        while (left <= mid) {
            temp[ind] = arr[left];
            ind ++;
            left ++;
        }

        while (right <= j) {
            temp[ind] = arr[right];
            ind ++;
            right ++;
        }

        for (int k = 0; k < temp.length; k ++) {
            arr[i + k] = temp[k];
        }

    }
}
