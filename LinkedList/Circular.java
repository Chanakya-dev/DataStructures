public class CircularLinkedList {
    Node head;

    // Define Node class for Circular Linked List
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add a node at the end (Circular)
    public void addNodeAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            System.out.println(data + " added at the end.");
            return;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
        System.out.println(data + " added at the end.");
    }

    // Method to add a node at the beginning
    public void addNodeAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            System.out.println(data + " added at the beginning.");
            return;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        newNode.next = head;
        head = newNode;
        last.next = head;
        System.out.println(data + " added at the beginning.");
    }

    // Method to delete a node from the beginning
    public void deleteNodeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == head) {
            head = null;
            System.out.println("Node deleted from the beginning.");
            return;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        head = head.next;
        last.next = head;
        System.out.println("Node deleted from the beginning.");
    }

    // Method to delete a node from the end
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == head) {
            head = null;
            System.out.println("Node deleted from the end.");
            return;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        Node temp = head;
        while (temp.next != current) {
            temp = temp.next;
        }
        temp.next = head;
        System.out.println("Node deleted from the end.");
    }

    // Method to search a node
    public boolean searchNode(int data) {
        if (head == null) {
            return false;
        }
        Node current = head;
        do {
            if (current.data == data) {
                System.out.println("Node with value " + data + " found.");
                return true;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with value " + data + " not found.");
        return false;
    }

    // Method to display the list
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(circular)");
    }

    // Method to clear the list
    public void clearList() {
        head = null;
        System.out.println("List cleared.");
    }

    // Method to get the size of the list
    public int getSize() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node current = head;
        while (current.next != head) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        // Adding nodes
        list.addNodeAtEnd(10);
        list.addNodeAtEnd(20);
        list.addNodeAtEnd(30);
        list.addNodeAtBeginning(5);
        
        // Displaying the list
        list.displayList();
        
        // Deleting nodes
        list.deleteNodeAtBeginning();
        list.deleteNodeAtEnd();
        
        // Displaying the updated list
        list.displayList();
        
        // Searching for nodes
        list.searchNode(20);
        list.searchNode(10);
        
        // Size of the list
        System.out.println("Size of the list: " + list.getSize());
        
        // Clearing the list
        list.clearList();
        list.displayList();
    }
}
