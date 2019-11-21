/**
 * A Simple RadixSort Algorithm. 
 * 
 * Given an array of integers, it sorts them by the most 
 * significant digit, until the most significant digit 
 * of the biggest integer has been touched.
 * 
 * @author seanlowjk
 */
public class RadixSort {

    /**
     * The RadixSort Algorithm. 
     * 
     * Given the highest value of the array, it sorts by 
     * ones, tent, hundreds so on and so forth until
     * the most significant digit of the largets number 
     * has been touched.
     * Worst Time Complexity: O(nd)
     * Best Time Complexity: O(nd)
     * Space Complexity: O(n+d)  
     * Note that d refers to the number of digits in the largest number.
     * @param arr the array to be sorted. 
     * @param len the length of the array. 
     */
    public void sort(int[] arr, int len) {
        int m = max(arr, len);
        for (int e = 1; (m/e) > 0; e *= 10) {
            move(arr, len, e);
        } 
    }

    /**
     * The algorithm to find the largest number in the array. 
     * @param arr the array to be sorted. 
     * @param len the length of the array. 
     * @return the largest numbver in the array. 
     */
    public int max(int[] arr, int len) {
        int m = arr[0];
        for (int i = 1; i < len; i ++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    } 

    /**
     * Shifts all elements to the designated positions. 
     * 
     * Creates 10 categories to store numbers based on the digits 0 to 9.
     * From there, it places the elements into the catgeory desginated. 
     * For example, if the digit we are looking at is the hundred, 
     * 111 belongs to category 1 and 7 (007) belongs to category 0. 
     * 
     * After which, it arranges the numbers based on ascending category.
     * This ensures that there is some form of ascending arrangement based 
     * on the digit that we are looking at.  
     * @param arr the array to be sorted. 
     * @param len the length of the array.
     * @param e the exponent of the number to look at. 
     */
    public void move(int[] arr, int len, int e) {
        int[] output = new int[len];
        int[] count = new int[10];
        for (int a = 0; a < 10; a ++) {
            count[a] = 0;
        }

        for (int i = 0; i < len; i ++) {
            int digit = (arr[i] / e) % 10;
            count[digit] ++;
        }

        for (int j = 1; j < 10; j ++) {
            count[j] += count[j - 1];
        }

        for (int k = len - 1; k >= 0; k --) {
            int digit = (arr[k]/e) % 10;
            int ind = count[digit] - 1;
            output[ind] = arr[k];
            count[digit] --;
        } 

        for (int l = 0; l < len; l ++) {
            arr[l] = output[l];
        }
    }
}
