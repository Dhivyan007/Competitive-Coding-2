import java.util.*; 
public class DiskTower { 
    static int n, max; 
    static int[] disks; 
    static PriorityQueue<Integer> heap = new 
PriorityQueue<>(Collections.reverseOrder()); 
    static void solveTower(int day) { 
        if (day == n) return; 
        heap.add(disks[day]); 
        System.out.print("Day " + (day + 1) + ": "); 
        while (!heap.isEmpty() && heap.peek() == max) { 
            System.out.print(heap.poll() + " "); 
            max--; 
        } 
        System.out.println(); 
        solveTower(day + 1); 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter number of disks: "); 
        n = sc.nextInt(); 
        disks = new int[n]; 
        System.out.println("Enter disk sizes:"); 
        for (int i = 0; i < n; i++) disks[i] = sc.nextInt(); 
        max = n; 
        System.out.println("Tower construction order:"); 
        solveTower(0); 
    } 
}
