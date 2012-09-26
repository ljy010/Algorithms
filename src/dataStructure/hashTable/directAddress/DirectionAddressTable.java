package dataStructure.hashTable.directAddress;

import dataStructure.hashTable.HashTable;
import dataStructure.hashTable.TableItem;

public class DirectionAddressTable implements HashTable {

	private int MAX_KEY = 100;
	
	private TableItem[] table;
	
	public DirectionAddressTable(){
		table = new TableItem[MAX_KEY];
	}

	@Override
	public TableItem search(Object key) {
		return table[(Integer)key];
	}

	@Override
	public void insert(Object newKey) {
		int k = (Integer) newKey;
		TableItem<Integer> newItem = new TableItem<Integer>();
		newItem.setData(k);
		table[k] = newItem;
	}

	@Override
	public TableItem delete(Object key) {
		TableItem<Integer> item = table[(Integer) key];
		table[(Integer) key] = null;
		return item;
	}
	
	public static void main(String[]  args){
		DirectionAddressTable d = new DirectionAddressTable();
		d.insert(23);
		d.insert(33);
		TableItem<Integer> i = d.search(33);
		System.out.println(i);
	}
	
	
}
