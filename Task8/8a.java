import java.util.*;

class CheapestFlightKStops {

    static class Flight {
        int city, cost, stops;
        Flight(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Build adjacency list: city -> list of (neighbor, cost)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], k -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Min-heap to explore lowest cost first
        PriorityQueue<Flight> pq = new PriorityQueue<>(Comparator.comparingInt(f -> f.cost));
        pq.offer(new Flight(src, 0, 0));

        // Track best costs with stops to avoid unnecessary work
        int[] costWithStops = new int[n];
        Arrays.fill(costWithStops, Integer.MAX_VALUE);
        costWithStops[src] = 0;

        while (!pq.isEmpty()) {
            Flight current = pq.poll();

            // Destination reached
            if (current.city == dst) {
                return current.cost;
            }

            // If stops exceed K, skip
            if (current.stops > K) continue;

            // Explore neighbors
            if (graph.containsKey(current.city)) {
                for (int[] next : graph.get(current.city)) {
                    int nextCity = next[0];
                    int nextCost = current.cost + next[1];

                    // Only proceed if this route is cheaper
                    if (nextCost < costWithStops[nextCity]) {
                        costWithStops[nextCity] = nextCost;
                        pq.offer(new Flight(nextCity, nextCost, current.stops + 1));
                    }
                }
            }
        }

        return -1; // No valid route found
    }

    // Test the program
    public static void main(String[] args) {
        CheapestFlightKStops solver = new CheapestFlightKStops();

        int n = 4; // Number of cities 0 to 3
        int[][] flights = {
                {0, 1, 200},
                {1, 2, 100},
                {0, 2, 500}
        };
        int src = 0, dst = 2, K = 1;

        int price = solver.findCheapestPrice(n, flights, src, dst, K);
        System.out.println("Cheapest Price = " + price);
    }
}
