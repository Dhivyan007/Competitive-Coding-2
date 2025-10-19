import java.util.*;

public class KClosestPoints {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(dist(b), dist(a)));
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > K) maxHeap.poll();
        }
        int[][] res = new int[K][2];
        for (int i = K-1; i >= 0; i--) res[i] = maxHeap.poll();
        return res;
    }

    private static int dist(int[] p) { return p[0]*p[0] + p[1]*p[1]; }

    public static void main(String[] args) {
        int[][] pts = {{1,3},{-2,2},{2,-2}};
        int[][] out = kClosest(pts,2);
        for (int[] p : out) System.out.println(Arrays.toString(p));
        // Expected two closest points
    }
}
