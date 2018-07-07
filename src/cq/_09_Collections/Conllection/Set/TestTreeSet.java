package cq._09_Collections.Conllection.Set;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Set:存储的元素是无序的，不可重复的！
 *  1.无序性：无序性！= 随机性。真正的无序性，指的是元素在底层存储的位置是无序的。
 *	2.不可重复性：当向Set中添加进相同的元素的时候，后面的这个不能添加进去。
 *
 *
 *
 *
 *
 */ 
public class TestTreeSet {
	
	@Test
	public void testTreeSet(){
		Set<String> set = new TreeSet<String>();
		set.add("s1");
		set.add("s2");
		set.add("s1");
		System.out.println("set:"+set);
	}
	
	/**
	 * 添加对象
	 */
	@Test
	public void testSetAddObject(){
		//Set<Person> p_set = new TreeSet<Person>();
		//p_set.add(new Person("p1", 18));
		//p_set.add(new Person("p2", 19));
		//p_set.add(new Person("p3", 20));
		//System.out.println("p_set:"+p_set);
	}
	
}
