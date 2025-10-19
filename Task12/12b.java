import java.util.*;

public class MinTaps {
    public static int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            maxReach[left] = Math.max(maxReach[left], right);
        }
        int taps = 0, curEnd = 0, nextEnd = 0;
        for (int i = 0; i <= n; i++) {
            if (i > nextEnd) return -1; // can't reach position i
            nextEnd = Math.max(nextEnd, maxReach[i]);
            if (i == curEnd) {
                if (curEnd != nextEnd) {
                    taps++;
                    curEnd = nextEnd;
                }
            }
            if (curEnd >= n) break;
        }
        return curEnd >= n ? taps : -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = {3,4,1,1,0,0}; // length n+1
        System.out.println(minTaps(n, ranges)); // 1
    }
}
