import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab2 {

    // Private recursive method to create a new list without the specified element
    private static <T> List<T> createWithoutElementsRec(List<T> originalList, T elementToRemove) {
        if (originalList.isEmpty()) {
            return new ArrayList<>();
        }
        T first = originalList.get(0);
        List<T> rest = originalList.subList(1, originalList.size());
        List<T> newList = createWithoutElementsRec(rest, elementToRemove);
        if (first.equals(elementToRemove)) {
            return newList;
        } else {
            newList.add(0, first);
            return newList;
        }
    }

    // Public method to remove elements using the private recursive method
    public static <T> List<T> RemoveElements(List<T> originalList, T elementToRemove) {
        return createWithoutElementsRec(originalList, elementToRemove);
    }

    // Original recursive method
    public static long seriesTerm(int n) {
        // Base cases: f(0) = 0, f(1) = 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // Recursive case: f(n) = 2 * f(n-1) + 3 * f(n-2)
            return 2 * seriesTerm(n - 1) + 3 * seriesTerm(n - 2);
        }
    }

    // Tail-recursive version of the seriesTerm method
    public static long seriesTermTail(int n) {
        return seriesTermTailHelper(n, 0, 1);
    }

    private static long seriesTermTailHelper(int n, long a, long b) {
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            return seriesTermTailHelper(n - 1, b, 2 * b + 3 * a);
        }
    }

    // Testing method to compare seriesTerm and seriesTermTail
    public static void testSeries(int n) {
        System.out.println("Testing seriesTerm and seriesTermTail for n = " + n);
        for (int i = 0; i <= n; i++) {
            System.out.println("n = " + i + ": " + (seriesTerm(i) == seriesTermTail(i)));
        }
    }

    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
    
        // First example
        List<Integer> firstList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            firstList.add(i);
        }
        System.out.println(RemoveElements(firstList, 2));
    
        // Second example
        System.out.println(RemoveElements(Arrays.asList(2), 2));
    
        // Third example
        System.out.println(RemoveElements(Arrays.asList("a", "b", "c"), "a"));
    
        // Fourth example
        System.out.println(RemoveElements(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
    
        // Fifth example
        System.out.println(RemoveElements(Arrays.asList("x", "y", "z"), "x"));
    
        // Task 2
        System.out.println("\nTask 2");
        testSeries(10);
    }
    
}    
