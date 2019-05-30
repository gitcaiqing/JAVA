package cq.java8.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class TestLambda {
	public static void main(String[] args) {
		
		
				 int i=9;
				 switch (i) {
				 default:
				 System.out.println("default");
				 case 0:
				 System.out.println("zero");
				 break;
				 case 1:
				 System.out.println("one");
				 break;
				 case 2:
				 System.out.println("two");
				 break;
				 }
	}
	
	List<Employ> employs = Arrays.asList(
		new Employ(18, 5555.55, "����"),
		new Employ(22, 6666.66, "����"),
		new Employ(33, 3333.33, "����"),
		new Employ(44, 9999.99, "����"),
		new Employ(55, 8888.88, "����"));
	//�������Ա��������Ա�����Ϸ���
	public List<Employ> getEmployByFilter(List<Employ> employs, EmployStrategy employStrategy){
		List<Employ> newEmploys = new ArrayList<Employ>();
		for(Employ employ : employs) {
			if(employStrategy.filterEmploy(employ)) {
				newEmploys.add(employ);
			}
		}
		return newEmploys;
	}
	
	//ͨ������ģʽʵ��
	@Test
	public void test() {
		//�����������
		List<Employ> ageFilterEmploys = getEmployByFilter(employs, new EmployFilterByAge());
		System.out.println("�������25��Ա����");
		for (Employ e : ageFilterEmploys) {
			System.out.println(e);
		}
		
		//���ݹ��ʹ���
		List<Employ> salaryFilterEmploys = getEmployByFilter(employs, new EmployFilterBySalary());
		System.out.println("���ʴ���6000��Ա����");
		for (Employ e : salaryFilterEmploys) {
			System.out.println(e);
		}
	}
	
	//ͨ�������ڲ���ʵ��
	@Test
	public void test2() {
		//�����������
		List<Employ> ageFilterEmploys = getEmployByFilter(employs, new EmployStrategy() {
			@Override
			public boolean filterEmploy(Employ employ) {
				return employ.getAge() > 25 ? true : false;
			}
		});
		System.out.println("�������25��Ա����");
		for (Employ e : ageFilterEmploys) {
			System.out.println(e);
		}
		//�����������
		List<Employ> salaryFilterEmploys = getEmployByFilter(employs, new EmployStrategy() {
			@Override
			public boolean filterEmploy(Employ employ) {
				return  employ.getSalary() > 6000 ? true : false;
			}
		});
		System.out.println("���ʴ���6000��Ա����");
		for (Employ e : salaryFilterEmploys) {
			System.out.println(e);
		}
	}
	
	//Lambda���ʽʵ��
	@Test
	public void test3() {
		List<Employ> ageFilterEmploys = getEmployByFilter(employs, e -> e.getAge() > 25);
		System.out.println("�������25��Ա����");
		for (Employ e : ageFilterEmploys) {
			System.out.println(e);
		}
		
		List<Employ> salaryFilterEmploys = getEmployByFilter(employs, e -> e.getSalary() > 6000);
		System.out.println("�������25��Ա����");
		for (Employ e : salaryFilterEmploys) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void test4() {
		new Thread(() -> System.out.println("�޲��޷���ֵLambda���ʽ")).start();
	}
	
	
	
/*	
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
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("aaaaaaaaaaaaa");
			}
		}).start();
		
		new Thread(() -> System.out.println());
	}
	
	@Test
	public void test2() {
		//������ȡ�������30��
		employs.forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		//������ȡ�������30��
		List<Employ> employs3 = employs.stream()
				.filter(e -> e.getAge()>30)
				.collect(Collectors.toList());
		System.out.println(employs3);
	}
	
	
	@Test
	public void test4() {
		//������ȡ�������30��
		List<Employ> employ4 = employs.stream().filter(e -> e.getName().equals("����")).collect(Collectors.toList());
		employ4.forEach(System.out::println);
	}
	
	@Test
	public void test5() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstanceStrong();
		System.out.println(secureRandom.nextInt());
	}
	
	
	private static final List<Integer> arrayList = Arrays.asList(1, 25, 6, 9, 22, 44);
	
	private static final int[] intArray = {1, 25, 6, 9, 22, 44};
	 
	
	//�ۼ�
	@Test
	public void test6(){
		int a =  arrayList.stream().reduce(Integer::sum).get();
		System.out.println(a);
	}
	//int�����ۼ��ۼ�
	@Test
	public void test7(){
		int sum =  Arrays.stream(intArray).boxed().reduce(Integer::sum).get();
		System.out.println(sum);
	}
	*/
	
	@Test
	public void test7(){
		java.util.Map<String, Object> map = new HashMap<>();
		String qydm = String.valueOf(map.get("qydm"));
		System.out.println(qydm);
	}
	
	
	
	
}
