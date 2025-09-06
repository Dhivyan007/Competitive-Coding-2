class RemoveElement { 
    Node head; 
    void push(int d) { 
        Node n = new Node(d); 
        n.next = head; 
        head = n; 
    } 
 
    void remove(int key) { 
        Node temp = head, prev = null; 
        if (temp != null && temp.data == key) { 
            head = temp.next; 
            return; 
        } 
        while (temp != null && temp.data != key) { 
            prev = temp; 
            temp = temp.next; 
        } 
        if (temp == null) return; // not found 
        prev.next = temp.next; 
    } 
 
    void printList() { 
        Node t = head; 
        while (t != null) { 
            System.out.print(t.data + " "); 
            t = t.next; 
        } 
    } 
    public static void main(String[] args) { 
        RemoveElement list = new RemoveElement(); 
        list.push(5); list.push(4); list.push(3); list.push(2); list.push(1); 
        System.out.print("Original List: "); 
        list.printList(); 
        list.remove(3); 
        System.out.print("\nAfter removing 3: "); 
        list.printList(); 
    } 
} 
