package exercise;

public class LinkedList {

    public Node head;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public LinkedList() {
        head = null;
    }

    public void addFront(int data) {
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }

        Node node = new Node(data);
        node.next = head;
        this.head = node;
    }

    public int getFirst() {
        if (head == null)
            throw new IllegalStateException("Empty List");

        return head.data;
    }

    public int getLast() {
        if (this.head == null)
            throw new IllegalStateException("Empty List");

        Node node = this.head;
        while (node.next != null) {
            node = node.next; // O(n)
        }
        return node.data;
    }

    public void addBack(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            return;
        }


        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(value);
    }

    public void clear() {
        this.head = null;
    }

    public int size() {
        Node node = this.head;
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }

        return counter;
    }

    public void deleteValue(int value) {

        if (head == null)
            return;

        if (head.data == value) {
            head = null;
            return;
        }

        Node previous = this.head;
        Node current = previous.next;
        while (current != null) {
            if (current.data == value) {
                previous.next = current.next;
                return;
            }
            current = current.next;
        }
    }

}
