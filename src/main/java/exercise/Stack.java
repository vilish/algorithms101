package exercise;

import java.util.EmptyStackException;

public class Stack {

	public Node head;

	private int size;

	public class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public Stack() {
		head = null;
	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;
	}

	public int pop() {

		if (head == null) {
			throw new EmptyStackException();
		}
		int data = head.data;
		head = head.next;
		size--;
		return data;

	}

	public int peek() {
		if (head == null) {
			throw new IllegalStateException("Empty Stack");
		}
		return head.data;

	}

	public int size() {
		return size;
	}

}
