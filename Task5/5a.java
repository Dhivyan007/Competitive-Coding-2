class Node { 
    int data; 
    Node next; 
    Node(int d) { data = d; next = null; } 
} 
class InsertionSortList { 
    Node head; 
    void push(int d) { 
        Node n = new Node(d); 
        n.next = head; 
        head = n; 
    } 
    void insertionSort() { 
        Node sorted = null; 
        Node curr = head; 
        while (curr != null) { 
            Node next = curr.next; 
            if (sorted == null || sorted.data >= curr.data) { 
                curr.next = sorted; 
                sorted = curr; 
            } else { 
                Node temp = sorted; 
                while (temp.next != null && temp.next.data < curr.data) 
                    temp = temp.next; 
                curr.next = temp.next; 
                temp.next = curr; 
            } 
            curr = next; 
        } 
        head = sorted; 
    } 
    void printList() { 
        Node t = head; 
        while (t != null) { 
            System.out.print(t.data + " "); 
            t = t.next; 
        } 
    } 
    public static void main(String[] args) { 
        InsertionSortList list = new InsertionSortList(); 
        list.push(3); 
        list.push(1); 
        list.push(2); 
        list.push(4); 
        System.out.print("Original List: "); 
        list.printList(); 
        list.insertionSort(); 
        System.out.print("\nSorted List: "); 
        list.printList(); 
    } }
