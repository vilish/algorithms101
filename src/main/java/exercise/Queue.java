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
		}

		Node node = head;

		while (node.next != null) {
			node = node.next;
		}

		node.next = new Node(data);

	}

	public int remove() {

		if (head == null) {
			throw new IllegalStateException("Empty Queue");
		}

		Node node = head;

		while (node.next != null) {
			node = node.next;
		}

		int data = node.data;
		node = null;

		return data;

	}

}
