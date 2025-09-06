import java.util.ArrayList; 
class BagOfNumbers { 
    private ArrayList<Integer> bag = new ArrayList<>(); 
    // Add number 
    public void add(int x) { 
        bag.add(x); 
    } 
    // Remove number (first occurrence) 
    public void remove(int x) { 
        if (bag.contains(x)) { 
            bag.remove(Integer.valueOf(x)); 
            System.out.println("Removing " + x + " from the bag..."); 
        } else { 
            System.out.println(x + " not found in the bag!"); 
        } 
    } 
    // Count occurrences 
    public int countOccurrences(int x) { 
        int count = 0; 
        for (int num : bag) { 
            if (num == x) count++; 
        } 
        return count; 
    } 
 
    // Check if empty 
    public boolean isEmpty() { 
        return bag.isEmpty(); 
    } 
    // Get bag size 
    public int size() { 
        return bag.size(); 
    } 
    // Display bag contents 
    public void display() { 
        System.out.println("Bag contents: " + bag); 
    } 
    // Main method 
    public static void main(String[] args) { 
        BagOfNumbers bag = new BagOfNumbers(); 
        System.out.println("Adding numbers: 5, 10, 5, 20"); 
        bag.add(5); 
        bag.add(10); 
        bag.add(5); 
        bag.add(20); 
        bag.display(); 
        System.out.println("Count occurrences of 5: " + 
bag.countOccurrences(5)); 
        bag.remove(5); 
        bag.display(); 
        System.out.println("Bag size: " + bag.size()); 
        System.out.println("Is the bag empty? " + bag.isEmpty()); 
        System.out.println("Removing all numbers..."); 
        bag.remove(10); 
        bag.remove(5); 
        bag.remove(20); 
        System.out.println("Is the bag empty now? " + bag.isEmpty()); 
    } 
} 
