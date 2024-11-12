public class DoublyLinkedList {
    Node head;

    // Define Node class for Doubly Linked List
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to add a node at the beginning
    public void addNodeAtBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
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
        newNode.prev = current;
    }

    // Method to add a node at a specific index
    public void addNodeAtIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Index cannot be negative");
            return;
        }

        Node newNode = new Node(data);
        if (index == 0) {
            addNodeAtBegin(data);
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Index out of range");
        } else {
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
        }
    }

    // Method to delete a node from the beginning
    public void deleteNodeAtBegin() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
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
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = null;
        } else {
            head = null;
        }
    }

    // Method to delete a node at a specific index
    public void deleteNodeAtIndex(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index or list is empty");
            return;
        }

        Node current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Index out of range");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current == head) {
            head = current.next;
        }
    }

    // Method to search for a node
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
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addNodeAtEnd(10);
        list.addNodeAtEnd(20);
        list.addNodeAtEnd(30);
        list.displayList();  

        list.addNodeAtBegin(5);
        list.displayList(); 

        list.addNodeAtIndex(2, 15);
        list.displayList();  

        list.deleteNodeAtBegin();
        list.displayList();  

        list.deleteNodeAtEnd();
        list.displayList(); 

        list.deleteNodeAtIndex(1);
        list.displayList();  

        System.out.println("Node with value 20 exists: " + list.searchNode(20));  
        System.out.println("Node with value 100 exists: " + list.searchNode(100)); 
    }
}
