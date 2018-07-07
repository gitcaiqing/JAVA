package cq._13_Reflection.TestReflection;

@MyAnnotation(value = "caiqing")
public class Person extends People<Object> implements MyInterface{
	public String name;
	public Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person(Integer age) {
		super();
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void say(){
		System.out.println("my name is:" + name);
	}
	
	@SuppressWarnings("unused")
	private void hello(String str){
		System.out.println("hello "+str);
	}
	@Override
	public void ImInterface() {
		// TODO Auto-generated method stub
		
	}
}
