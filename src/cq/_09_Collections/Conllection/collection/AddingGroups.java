package cq._09_Collections.Conllection.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AddingGroups {
	
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		System.out.println(collection);
		
		Integer[] moreInts = {5,6,7};
		collection.addAll(Arrays.asList(moreInts));
		System.out.println(collection);
		
		Collections.addAll(collection, 8,9,10);
		System.out.println(collection);
		
		Collections.addAll(collection, moreInts);
		System.out.println(collection);
	}
}
