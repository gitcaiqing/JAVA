package cq._09_Collections.Conllection.Set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/**
 * LinkedHashSet:使用链表维护了一个添加进集合中的顺序。导致当我们遍历LinkedHashSet集合
 * 元素时，是按照添加进去的顺序遍历的！
 * 
 * LinkedHashSet插入性能略低于 HashSet，但在迭代访问 Set 里的全部元素时有很好的性能。
 */
public class TestLinkedHashSet {
	@Test
	public void testLinkedHashSet(){
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("l01");
		linkedHashSet.add("l02");
		linkedHashSet.add("l03");
		
		linkedHashSet.add("l02");
		linkedHashSet.add(new String("l02"));
		
		Iterator<String> it = linkedHashSet.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
			//l01 l02 l03
		}
	}
}
