import java.util.Arrays;

public class ConnectTwoGroups {

    public int connectTwoGroups(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;
        int maxMask = 1 << n;
        int[][] dp = new int[m + 1][maxMask];

        // Initialize dp with large value
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        // DP Transition
        for (int i = 1; i <= m; i++) {
            for (int mask = 0; mask < maxMask; mask++) {
                for (int j = 0; j < n; j++) {
                    int newMask = mask | (1 << j);
                    dp[i][newMask] = Math.min(dp[i][newMask], dp[i - 1][mask] + cost[i - 1][j]);
                }
            }
        }

        // Ensure each Group 2 point is connected
        int result = Integer.MAX_VALUE;
        for (int mask = 0; mask < maxMask; mask++) {
            if (isValid(mask, n)) {
                result = Math.min(result, dp[m][mask]);
            }
        }

        return result;
    }

    // Check if mask connects all Group 2 points
    private boolean isValid(int mask, int n) {
        return mask == (1 << n) - 1;  // all bits set = all Group 2 used
    }

    // Test the code
    public static void main(String[] args) {
        int[][] cost = {
            {3, 2, 4},
            {6, 5, 7}
        };

        ConnectTwoGroups solver = new ConnectTwoGroups();
        int result = solver.connectTwoGroups(cost);
        System.out.println("Minimum cost to connect both groups = " + result);
    }
}
