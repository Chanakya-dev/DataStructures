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
            return;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
    }

    // Method to add a node at the beginning
    public void addNodeAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        newNode.next = head;
        head = newNode;
        last.next = head;
    }

    // Method to add a node at a specific position
    public void addNodeAtPosition(int position, int data) {
        if (position < 1 || position > getSize() + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addNodeAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        int count = 1;
        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node from the beginning
    public void deleteNodeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }
        head = head.next;
        last.next = head;
    }

    // Method to delete a node from the end
    public void deleteNodeAtEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node current = head;
        Node previous = null;
        while (current.next != head) {
            previous = current;
            current = current.next;
        }
        previous.next = head;
    }

    // Method to delete a node at a specific position
    public void deleteNodeAtPosition(int position) {
        if (position < 1 || position > getSize()) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            deleteNodeAtBeginning();
            return;
        }
        Node current = head;
        Node previous = null;
        int count = 1;
        while (count < position && current.next != head) {
            previous = current;
            current = current.next;
            count++;
        }
        previous.next = current.next;
    }

    // Method to search a node
    public boolean searchNode(int data) {
        if (head == null) {
            return false;
        }
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    // Method to get data at a specific position
    public int getNodeAtPosition(int position) {
        if (position < 1 || position > getSize()) {
            throw new IllegalArgumentException("Invalid position!");
        }
        Node current = head;
        int count = 1;
        while (count < position && current.next != head) {
            current = current.next;
            count++;
        }
        return current.data;
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
        list.addNodeAtEnd(10);
        list.addNodeAtEnd(20);
        list.addNodeAtEnd(30);
        list.addNodeAtBeginning(5);
        list.addNodeAtPosition(2, 15);
        list.displayList();

        list.deleteNodeAtBeginning();
        list.deleteNodeAtEnd();
        list.deleteNodeAtPosition(2);
        list.displayList();

        System.out.println("Node at position 2: " + list.getNodeAtPosition(2));
        System.out.println("List contains 20: " + list.searchNode(20));
        System.out.println("Size of the list: " + list.getSize());

        list.clearList();
        list.displayList();
    }
}
