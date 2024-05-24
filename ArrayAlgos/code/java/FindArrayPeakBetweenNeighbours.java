import java.util.*;
public class FindArrayPeakBetweenNeighbours {
    public static int findPeak(int arr[], int n) {
        if (n == 1) {
            return arr[0];
        }

        if (arr[0] > arr[1]) { // strictly decreasing case
            return arr[0];
        }

        if (arr[n - 1] > arr[n - 2]) { // strictly increasing case
            return arr[n - 1];
        }

        // else all other scenarios
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return arr[0]; // all elements in arr are equal
    }

    public static void main(String[] args) {
        int arr[] = {10, 15, 2, 23, 90, 67};
        System.out.println("Peak point of array is: " + findPeak(arr, arr.length));
    }
}
