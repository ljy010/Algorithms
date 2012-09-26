package dataStructure.hashTable;

public class TableItem<T> {

	private T data;
	
	private TableItem<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TableItem<T> getNext() {
		return next;
	}

	public void setNext(TableItem<T> next) {
		this.next = next;
	}

	
}
