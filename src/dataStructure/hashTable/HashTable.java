package dataStructure.hashTable;

public interface HashTable<T> {

	TableItem<T> search(T key);
	
	void insert(T newKey);
	
	TableItem<T> delete(T key);
	
}
