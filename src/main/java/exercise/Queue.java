package exercise;

import exercise.Stack.Node;

public class Queue {

    public Node head;

    private int size;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }

        Node node = head;

        while (node.next != null) {
            node = node.next;
        }
        size++;
        node.next = new Node(data);

    }

    /**
     * should remove the first element
     */
    public void remove() {

        if (head == null) {
            throw new IllegalStateException("Empty Queue");
        }

//        if(head.data == )
        head = head.next;
//        Node node = head;
//
//        while (node.next != null) {
//            node = node.next;
//        }
//
//        int data = node.data;
//        node = null;
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
