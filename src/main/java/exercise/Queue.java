package exercise;

import exercise.Stack.Node;

public class Queue {

    private Node head; // remove things here
    private Node tail; // add things here

    private int size;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {

        Node newNode = new Node(data);


        // if tail is empty, queue should be empty
        if (tail == null) {
            tail = newNode;
            head = tail;
            size++;
            return;
        }


        // start from head and reach at tail
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }

        // now 'node' should be at tail
        node.next = new Node(data);  // add node
        tail = node; // reset tail

        size++;

    }

    /**
     * should remove the first element
     */
    public void remove() {

        if (head == null) {
            throw new IllegalStateException("Empty Queue");
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return;

    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Empty Queue");
        }
        return head.data;

    }

    public int size() {
        return size;
    }

}
