package cq.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class TestPredicate {
	//�Ӽ����л�ȡ��������������Ԫ�ط����¼��ϲ�����
	public List<Integer> getList(List<Integer> list, Predicate<Integer> pre){
		List<Integer> listNew = new ArrayList<>();
		for(Integer v : list) {
			if(pre.test(v)) {
				listNew.add(v);
			}
		}
		return listNew;
	}
	@Test
	public void test() {
		List<Integer> list = Arrays.asList(39,8,12,99,22);
		//��ȡֵС��30���������¼���
		List<Integer> listNew = getList(list, (value) -> value < 30);
		System.out.println("С��30��"+listNew);
		//��ȡֵ����40���������¼���
		listNew = getList(list, value -> value > 40);
		System.out.println("����40��"+listNew);
	}
}
