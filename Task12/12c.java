public class WaterBottles {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int newFull = empty / numExchange;
            total += newFull;
            empty = empty % numExchange + newFull;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3)); // 13
        System.out.println(numWaterBottles(15, 4)); // 19
    }
}
