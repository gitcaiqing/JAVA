package cq.java8.lambda;

//����һ����������ɸѡ��ʵ����
public class EmployFilterByAge implements EmployStrategy{
	@Override
	public boolean filterEmploy(Employ employ) {
		return  employ.getAge() > 25 ? true : false;
	}
}
