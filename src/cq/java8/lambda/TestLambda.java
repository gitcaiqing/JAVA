package cq.java8.lambda;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestLambda {
	
	static {
		List<Employ> employs = new ArrayList<>();
		employs.add(new Employ(18, 5555.55, "张三"));
		employs.add(new Employ(22, 6666.66, "李四"));
		employs.add(new Employ(33, 3333.33, "王五"));
		employs.add(new Employ(44, 9999.99, "赵六"));
		employs.add(new Employ(55, 8888.88, "田七"));
	}
	
	@Test
	public void test1() {
		Comparable<Integer> com = new Comparable<Integer>() {
			@Override
			public int compareTo(Integer num) {
				return Integer.compare(10, num);
			}
		};
		System.out.println(com.compareTo(20));
		
		Comparable<Integer> com2 = (x) -> Integer.compare(10, x);
		System.out.println(com2.compareTo(20));
	}
	
	public void test2() {
		
	}
	
	
}
