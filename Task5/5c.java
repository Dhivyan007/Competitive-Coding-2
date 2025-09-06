import java.util.*; 
class RemoveDuplicates { 
    Node head; 
    void push(int d) { 
        Node n = new Node(d); 
        n.next = head; 
        head = n; 
    } 
    void removeDup() { 
        HashSet<Integer> set = new HashSet<>(); 
        Node curr = head, prev = null; 
        while (curr != null) { 
            if (set.contains(curr.data)) { 
                prev.next = curr.next; 
            } else { 
                set.add(curr.data); 
                prev = curr; 
            } 
            curr = curr.next; 
        } 
    } 
 
    void printList() { 
        Node t = head; 
        while (t != null) { 
            System.out.print(t.data + " "); 
            t = t.next; 
        } 
    } 
    public static void main(String[] args) { 
        RemoveDuplicates list = new RemoveDuplicates(); 
        list.push(5); list.push(4); list.push(4); list.push(3); 
        list.push(2); list.push(2); list.push(1); 
        System.out.print("Original List: "); 
        list.printList(); 
        list.removeDup(); 
        System.out.print("\nAfter removing duplicates: "); 
        list.printList(); 
    } 
} 
