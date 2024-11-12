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

    // Method to delete a node from the beginning
    public void deleteNodeAtBeginning() {
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
        list.deleteNodeAtEnd();
        list.displayList();
        list.deleteNodeAtBeginning();
        list.displayList();
        System.out.println("Node with value 20 exists: " + list.searchNode(20));
    }
}
