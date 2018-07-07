package cq.InnerClass;

//�ⲿ��
public class CreateInnerClass {
	//�ڲ���
	class Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	class Destination{
		
		//CreateInnerClass createInnerClass = CreateInnerClass.this;
		
		private String label;
		public Destination(String whereTo) {
			label = whereTo;
		}
		String readLable() {
			return label;
		}
	}

	public void ship(String dest) {
		Destination destination = new Destination(dest);
		System.out.println(destination.readLable());
	}
	
	//�ⲿ�෽������ֵ ָ���ڲ���
	public Destination toInner(String s) {
		return new Destination(s);
	}
	
	public static void main(String[] args) {
		CreateInnerClass createInnerClass = new CreateInnerClass();
		createInnerClass.ship("a");
		
		Destination destination = createInnerClass.toInner("toinner");
		System.out.println(destination);
		
		//�����ڲ������
		Destination destination2 = new CreateInnerClass().new Destination("a");
	}
}
