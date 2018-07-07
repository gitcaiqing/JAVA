package cq._09_Collections.Conllection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.Test;

	/**ArrayList��List����Ҫʵ����
	 * 
	 * List�������Collection�������ӵķ���
	 *
	 *  void add(int index, Object ele):��ָ��������λ��index���Ԫ��ele
		boolean addAll(int index, Collection eles)
		Object get(int index):��ȡָ��������Ԫ��
		Object remove(int index):ɾ��ָ������λ�õ�Ԫ��
		Object set(int index, Object ele):����ָ������λ�õ�Ԫ��Ϊele
		int indexOf(Object obj):����obj�ڼ������״γ��ֵ�λ�á�û�еĻ�������-1
		int lastIndexOf(Object obj)������obj�ڼ��������һ�γ��ֵ�λ��.û�еĻ�������-1
		List subList(int fromIndex, int toIndex):���ش�fromIndex��toIndex����������ҿ�һ����list
		
		List���õķ�������(add(Object obj)) ɾ(remove) ��(set(int index,Object obj))
					��(get(int index)) ��(add(int index, Object ele)) ����(size())
	 */
	
 
public class TestList {
	public static void main(String[] args) {
		
	}
	
	/**
	 * ArrayList ˳��洢
	 * ArrayList��ʵ�ǰ�װ��һ������ Object[]����ʵ����һ��ArrayListʱ��һ������Ҳ��ʵ����������ArrayList����Ӷ����ǣ�����Ĵ�СҲ��Ӧ�ĸı䡣�����ʹ���������ȱ�㣺
	 * �����漴���� ������漴����ÿ��Ԫ�ض����ÿ����������⣬ͨ������get(i)�����������±�Ϊi������Ԫ�ء�
	 * ��������Ӷ����ٶ��� ���㴴�������ǲ�����ȷ�������������Ե��ı��������ʱ�ͱ������ڴ������ܶ����顣
	 * �������ж�����ٶ��� ����Ҫ����������������Ԫ���м���Ӷ���ʱ��������Ҫ�ƶ����к���Ķ���
	 */
	@Test
	public void testArrayList(){
		/**1.��������*/
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(11);
		arrayList.add(22);
		arrayList.add(33);
		System.out.println("arrayList:"+arrayList);
		
		/**2.��������*/
		//2.1��ͨforѭ��
		System.out.println("��ͨforѭ��----------");
		for(int i=0 ;i<arrayList.size(); i++){
			System.out.println(i+"--->"+arrayList.get(i));
		}
		
		//2.2��ǿforѭ��
		System.out.println("��ǿforѭ��----------");
		for(Integer list:arrayList){
			System.out.println(arrayList.indexOf(list) +"--->"+list);
		}
		//2.3������ iterator
		System.out.println("iterator----------");
		Iterator<Integer> it = arrayList.iterator();
		while(it.hasNext()){
			System.out.println( "--->"+it.next());
		}
	}
	
	/**
	 * LinkedList ��ʽ�洢  ����Ƶ���Ĳ��롢ɾ������
	 * LinkedList��ͨ���ڵ�ֱ�ӱ˴�������ʵ�ֵġ�
	 * ÿһ���ڵ㶼����ǰһ���ڵ�����ã���һ���ڵ�����úͽڵ�洢��ֵ��
	 * ��һ���½ڵ����ʱ��ֻ��Ҫ�޸����б����Ⱥ��ϵ�Ľڵ�����ü��ɣ�
	 * ��ɾ����¼ʱҲһ���������ʹ���������ȱ�㣺
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
	 * Vector�����ϵ�ʵ���ࡢ�̰߳�ȫ�ģ���Ч��Ҫ����ArrayList��
	 */
	@Test
	public void testVector(){
		Vector<String> vector = new Vector<String>();
		vector.add("v01");
		vector.add("v02");
		vector.add("v03");
		System.out.println("vector:"+vector);
		
		//Vector ���ṩ��ʵ�ֿ���������Ĺ��ܣ����Ÿ���Ԫ�ؼ������У������ĸ�����ɾ��һЩԪ��֮�������С�� 
		//��ӵ�β��
		vector.addElement("v00");
		
		System.out.println("vector:"+vector);
		//��2��λ�ò���
		vector.insertElementAt("v22", 2);
		System.out.println("vector:"+vector);
		
		
	}
}












