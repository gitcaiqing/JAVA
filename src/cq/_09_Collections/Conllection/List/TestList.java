package cq._09_Collections.Conllection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

	/**ArrayList：List的主要实现类
	 * 
	 * List中相对于Collection，新增加的方法
	 *
	 *  void add(int index, Object ele):在指定的索引位置index添加元素ele
		boolean addAll(int index, Collection eles)
		Object get(int index):获取指定索引的元素
		Object remove(int index):删除指定索引位置的元素
		Object set(int index, Object ele):设置指定索引位置的元素为ele
		int indexOf(Object obj):返回obj在集合中首次出现的位置。没有的话，返回-1
		int lastIndexOf(Object obj)：返回obj在集合中最后一次出现的位置.没有的话，返回-1
		List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex结束的左闭右开一个子list
		
		List常用的方法：增(add(Object obj)) 删(remove) 改(set(int index,Object obj))
					查(get(int index)) 插(add(int index, Object ele)) 长度(size())
	 */
	
 
public class TestList {
	public static void main(String[] args) {
		
	}
	
	/**
	 * ArrayList 顺序存储
	 * ArrayList其实是包装了一个数组 Object[]，当实例化一个ArrayList时，一个数组也被实例化，当向ArrayList中添加对象是，数组的大小也相应的改变。这样就带来以下有缺点：
	 * 快速随即访问 你可以随即访问每个元素而不用考虑性能问题，通过调用get(i)方法来访问下标为i的数组元素。
	 * 向其中添加对象速度慢 当你创建数组是并不能确定其容量，所以当改变这个数组时就必须在内存中做很多事情。
	 * 操作其中对象的速度慢 当你要想数组中任意两个元素中间添加对象时，数组需要移动所有后面的对象。
	 */
	@Test
	public void testArrayList(){
		/**1.创建集合*/
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(11);
		arrayList.add(22);
		arrayList.add(33);
		System.out.println("arrayList:"+arrayList);
		
		/**2.遍历集合*/
		//2.1普通for循环
		System.out.println("普通for循环----------");
		for(int i=0 ;i<arrayList.size(); i++){
			System.out.println(i+"--->"+arrayList.get(i));
		}
		
		//2.2增强for循环
		System.out.println("增强for循环----------");
		for(Integer list:arrayList){
			System.out.println(arrayList.indexOf(list) +"--->"+list);
		}
		//2.3迭代器 iterator
		System.out.println("iterator----------");
		Iterator<Integer> it = arrayList.iterator();
		while(it.hasNext()){
			System.out.println( "--->"+it.next());
		}
	}
	
	/**
	 * LinkedList 链式存储  对于频繁的插入、删除操作
	 * LinkedList是通过节点直接彼此连接来实现的。
	 * 每一个节点都包含前一个节点的引用，后一个节点的引用和节点存储的值。
	 * 当一个新节点插入时，只需要修改其中保持先后关系的节点的引用即可，
	 * 当删除记录时也一样。这样就带来以下有缺点：
	 */
	@Test
	public void testLinkedList(){
		List<String> linkedList = new LinkedList<String>();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		System.out.println("linkedList:"+linkedList);
	}
	/**
	 * Vector（古老的实现类、线程安全的，但效率要低于ArrayList）
	 */
	@Test
	public void testVector(){
		Vector<String> vector = new Vector<String>();
		vector.add("v01");
		vector.add("v02");
		vector.add("v03");
		System.out.println("vector:"+vector);
		
		//Vector 类提供了实现可增长数组的功能，随着更多元素加入其中，数组变的更大。在删除一些元素之后，数组变小。 
		//添加到尾部
		vector.addElement("v00");
		
		System.out.println("vector:"+vector);
		//在2的位置插入
		vector.insertElementAt("v22", 2);
		System.out.println("vector:"+vector);
		
		
	}
}












