package exercise;

public class LinkedList {

	public Node head;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public LinkedList() {
		head = null;
	}

	public void addFront(int data) {
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
		if (this.head == null)
			this.head = new Node(value);

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
		if (this.head == null)
			return 0;

		Node node = this.head;
		int counter = 0;
		while (node.next != null) {
			counter++;
			node = node.next;
		}

		return counter;
	}

	public void deleteValue(int value) {

		Node previous = this.head;
		Node current = previous.next;
		while (previous != null) {
			if (previous.data == value) {
				previous = current;
				return;
			}
			if (current != null) {
				previous = current;
			}
		}
	}

}
