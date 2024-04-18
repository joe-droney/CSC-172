//Joe Droney

public class Lab4 {
    public static int binarySearch(int arr[], int target, int start, int end) {
        while (start <= end) {
            int midIndex = (start + end) / 2;
            if (arr[midIndex] == target) {
                return midIndex;
            }
            if (arr[midIndex] < target) {
                start = midIndex + 1;
            } else {
                end = midIndex - 1;
            }
        }
        return -1; // If the element is not found
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found
    }
}

class SearchTest {

    public static void main(String[] args) {
        testBinarySearch();
        testLinearSearch();
        measureSearchTime();
    }

    public static void testBinarySearch() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        // Test cases where target element is present
        assert Lab4.binarySearch(arr, 11, 0, arr.length - 1) == 5;
        assert Lab4.binarySearch(arr, 1, 0, arr.length - 1) == 0;
        assert Lab4.binarySearch(arr, 15, 0, arr.length - 1) == 7;

        // Test cases where target element is not present
        assert Lab4.binarySearch(arr, 8, 0, arr.length - 1) == -1;
        assert Lab4.binarySearch(arr, 0, 0, arr.length - 1) == -1;
    }

    public static void testLinearSearch() {
        int[] arr = {4, 2, 7, 1, 9, 5, 3};

        // Test cases where target element is present
        assert Lab4.linearSearch(arr, 5) == 5;
        assert Lab4.linearSearch(arr, 4) == 0;
        assert Lab4.linearSearch(arr, 3) == 6;

        // Test cases where target element is not present
        assert Lab4.linearSearch(arr, 8) == -1;
        assert Lab4.linearSearch(arr, 0) == -1;
    }

    public static void measureSearchTime() {
        System.out.println("Binary Search:");
        measureBinarySearch();
        System.out.println("Linear Search:");
        measureLinearSearch();
    }

    public static void measureBinarySearch() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int inputSize : new int[]{10, 100, 500, 1000, 5000, 10000, 50000, 100000}) {
            int target = inputSize; // Assuming target is present
            long startTime = System.nanoTime();
            int index = Lab4.binarySearch(arr, target, 0, arr.length - 1);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Input size: " + inputSize + ", Execution time: " + executionTime + " nanoseconds");
        }
    }

    public static void measureLinearSearch() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int inputSize : new int[]{10, 100, 500, 1000, 5000, 10000, 50000, 100000}) {
            int target = inputSize; // Assuming target is present
            long startTime = System.nanoTime();
            int index = Lab4.linearSearch(arr, target);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            System.out.println("Input size: " + inputSize + ", Execution time: " + executionTime + " nanoseconds");
        }
    }
}
