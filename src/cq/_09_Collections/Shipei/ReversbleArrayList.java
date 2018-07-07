package cq._09_Collections.Shipei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ReversbleArrayList<T> extends ArrayList<T>{

	public ReversbleArrayList(Collection<T> c) {
		super(c);
	} 
	
	public Iterable<T> reversed(){
		return new Iterable<T>() {

			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() -1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}

					@Override
					public T next() {
						return get(current--);
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
					
				};
			}
			
		};
		
	}
}
