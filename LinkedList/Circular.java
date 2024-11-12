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

    // Method to delete a node from the beginning
    public void deleteNodeAtBeginning() {
        if (head != null) {
            if (head.next == head) {
                head = null;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                head = head.next;
                current.next = head;
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
        if (head.next == head) {
            head = null;
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

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
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
