package cq.java8.lambda;

//����һ�����ݹ���ɸѡ��ʵ����
public class EmployFilterBySalary implements EmployStrategy{
	@Override
	public boolean filterEmploy(Employ employ) {
		return  employ.getSalary() > 6000 ? true : false;
	}
}
