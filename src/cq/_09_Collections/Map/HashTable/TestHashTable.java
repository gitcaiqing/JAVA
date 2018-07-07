package cq._09_Collections.Map.HashTable;

import java.util.Hashtable;

import org.junit.Test;

public class TestHashTable {
	
	@Test
	public void testHashTable() {
		Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
		hashtable.put("a", "aa");
		hashtable.put("b", "bb");
		System.out.println(hashtable);
	}

}
