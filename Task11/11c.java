import java.util.*;

public class MinCostTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length - 1];
        boolean[] travel = new boolean[last + 1];
        for (int d : days) travel[d] = true;
        int[] dp = new int[last + 1];
        for (int i = 1; i <= last; i++) {
            if (!travel[i]) dp[i] = dp[i-1];
            else {
                dp[i] = Math.min(dp[i-1] + costs[0],
                          Math.min(dp[Math.max(0, i-7)] + costs[1],
                                   dp[Math.max(0, i-30)] + costs[2]));
            }
        }
        return dp[last];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days, costs)); // 11
    }
}
