import java.util.*;

public class KSmallestPairs {
    static class Pair {
        int sum, i, j;
        Pair(int sum, int i, int j) { this.sum = sum; this.i = i; this.j = j; }
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) return res;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new Pair(nums1[i] + nums2[0], i, 0));
        }

        while (!pq.isEmpty() && res.size() < k) {
            Pair p = pq.poll();
            res.add(new int[]{nums1[p.i], nums2[p.j]});
            if (p.j + 1 < nums2.length) {
                pq.offer(new Pair(nums1[p.i] + nums2[p.j + 1], p.i, p.j + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,7,11};
        int[] b = {2,4,6};
        List<int[]> ans = kSmallestPairs(a,b,5);
        for (int[] p : ans) System.out.println(Arrays.toString(p));
        // Expected up to 5 smallest pairs by sum
    }
}
