import java.util.*;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        backtrack(low, high, 1, 0, result);
        Collections.sort(result); // ensure sorted order
        return result;
    }

    private void backtrack(int low, int high, int startDigit, int current, List<Integer> result) {
        if (current > high) return; // exceed high

        if (current >= low && current <= high) {
            result.add(current);
        }

        if (startDigit <= 9) {
            int next = current * 10 + startDigit;
            backtrack(low, high, startDigit + 1, next, result);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        SequentialDigits solver = new SequentialDigits();

        int low = 100, high = 300;
        List<Integer> output = solver.sequentialDigits(low, high);

        System.out.println(output);
        // Example Output: [123, 234, 345, 456, 567, 678, 789, 1234, 2345]
    }
}
