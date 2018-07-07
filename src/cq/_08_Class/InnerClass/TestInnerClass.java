package cq._08_Class.InnerClass;

public class TestInnerClass {
	
	public static void main(String[] args) {
		System.out.println("��Ա�ڲ���------------------");
		//�����Ǿ�̬���ڲ���Ķ��󣺱����ȴ����ⲿ��Ķ���
		//ͨ���ⲿ��Ķ�������ڲ���Ĺ�����
		Person p = new Person();
		Person.Bird b = p.new Bird();
		b.setName("�ž�");
		b.info();
			
		//������̬�ڲ���Ķ��󣺿���ֱ��ͨ���ⲿ����þ�̬�ڲ���Ĺ�����
		System.out.println("��̬�ڲ���------------------");
		Person.Dog d = new Person.Dog();
		d.setName("dog");
		
		//�ֲ��ڲ��� ����ķ�����������һ����
		System.out.println("�ֲ��ڲ���------------------");
		p.method();
		
		
	}
	
}


class Person{
	String name = "����";
	int age;
	public boolean say(){
		return true;
	}
	public void show(){
		System.out.println("����show()����");
	}
	
	/**1.��Ա�ڲ���
	 * ���ⲿ���һ����Ա���� ���������η� static/final
	 * ���Ե����ⲿ������Ժͷ���
	 * ��������ص�abstract, ���������ڲ��������Է���������
	 * 
	 * */
	
	//1.1���Ǿ�̬��Ա�ڲ���
	class Bird{
		String name = "���";
		int id;
		public Bird(){
			
		}
		public void setName(String name){
			System.out.println(name);//�ž� 
			System.out.println(this.name);//��� this�Ǳ���Bird
			System.out.println(Person.this.name);//���� Person.this �����ⲿ�������
			Person.this.say();
		}
		public void info(){
			show();
		}
	}
	//1.2����̬��Ա�ڲ���
	static class Dog{
		String name = "static dog";
		
		public void setName(String name){
			System.out.println(name);//�ž� 
			System.out.println(this.name);//��� this�Ǳ���Bird
			
			//���� Person.this �޷� �����ⲿ������Ժͷ���
			// ���� System.out.println(Person.this.name);
		}
	}

	
	
	/**
	 * �ֲ��ڲ���(��������ķ�����)
	 */
	public void method(){
		
		String name = "method";
		
		class jubuClass{
			
			String name = "Jubu";
			
			public void setName(String name){
				System.out.println(name);//�ֲ��ڲ���setname"
				System.out.println(this.name);//Jubu
				System.out.println(Person.this.name);//����
			}
			
		}
		
		new jubuClass().setName("�ֲ��ڲ���setname");
		
	}
}







