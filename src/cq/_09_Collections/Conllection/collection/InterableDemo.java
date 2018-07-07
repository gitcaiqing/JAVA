package cq._09_Collections.Conllection.collection;

import java.util.Map;

public class InterableDemo {

	public static void main(String[] args) {
		for(Map.Entry entry: System.getenv().entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
