package exercise;

public class DynamicArray<String> {

	private Object[] data;
	private int size;
	private int initialCapacity;

	public DynamicArray(int initialCapacity) {
		this.initialCapacity = initialCapacity;
		data = new Object[initialCapacity];
	}

	public String get(int index) {
		return (String) data[index];
	}

	public void set(int index, String value) {
		data[index] = value;
	}

	public void delete(int index) {

	}

	public boolean isEmpty() {

		return data.length == 0 ? true : false;
	}

	public boolean Contains(String value) {

		return false;
	}

	public void add(String value) {

	}

	public int size() {
		return 0;

	}

	public void print() {

	}

	public void insert(int i, String string) {
		// TODO Auto-generated method stub

	}

	private void resize() {

	}
}