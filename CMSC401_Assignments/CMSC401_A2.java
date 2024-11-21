/*
 * Name: Richard Elliott Jr
 * Title: CMSC401_A2
 * Last Date Modified: 10/6/24
 * Description: This code finds the Xth largest number from a list of numbers 
 * submitted by students using the Quickselect algorithm, which runs in an 
 * average time complexity of O(N).
 */
import java.util.Scanner;

public class CMSC401_A2 {

    // Quickselect to find the Xth largest element
    public static int quickSelect(int[] arr, int left, int right, int X) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left,right);

        // Number of elements greater than the pivot
        int k = pivotIndex - left + 1;

        if (X == k) {
            return arr[pivotIndex];
        } else if (X < k) {
            return quickSelect(arr, left, pivotIndex - 1, X);
        }else {
            return quickSelect(arr,pivotIndex + 1, right, X - k);
        }
    }

    // Partition method used in Quickselect
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] >= pivot) { // Keep the larger elements on the left side
                swap(arr, i, j); 
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    // Utility to swap elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of studnets (N)
        int N = scanner.nextInt();

        // Read the order (X) of the Xth largest number
        int X = scanner.nextInt();

        // Read the numbers provided by students
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Find the Xth largest number
        int result = quickSelect(numbers, 0, N - 1, X);

        // Output the result
        System.out.println(result);

        scanner.close();
    }
}