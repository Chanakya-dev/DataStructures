public class SinglyLinkedList {
    Node head;

    // Define Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a node at the end
    public void addNodeAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to add a node at the beginning
    public void addNodeAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to add a node at a specific index
    public void addNodeAtIndex(int index, int data) {
        // Create a new node
        Node newNode = new Node(data);
        
        // If the index is 0, add at the beginning
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Traverse the list to the specified index
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        // If the index is out of bounds
        if (current == null) {
            System.out.println("Index out of bounds!");
            return;
        }

        // Insert the new node at the specified index
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node from the beginning
    public void deleteNodeAtBeginning() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is empty!");
        }
    }

    // Method to delete a node from the end
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Method to delete a node at a specific index
    public void deleteNodeAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        // If the index is 0, delete the first node
        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        // If the index is out of bounds
        if (current == null || current.next == null) {
            System.out.println("Index out of bounds!");
            return;
        }

        // Skip the node at the specified index
        current.next = current.next.next;
    }

    // Method to search a node
    public boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to display the list
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addNodeAtEnd(10);
        list.addNodeAtEnd(20);
        list.addNodeAtEnd(30);
        list.displayList(); 

       
        list.addNodeAtBeginning(5);
        list.displayList();

      
        list.addNodeAtIndex(2, 15);
        list.displayList();

        
        list.deleteNodeAtIndex(2); 
        list.displayList(); 

        // Test delete methods
        list.deleteNodeAtEnd();
        list.displayList(); 

        list.deleteNodeAtBeginning();
        list.displayList(); 
        System.out.println("Node with value 20 exists: " + list.searchNode(20)); // true
        System.out.println("Node with value 100 exists: " + list.searchNode(100)); // false
    }
}
