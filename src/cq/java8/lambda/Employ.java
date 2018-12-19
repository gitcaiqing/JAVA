package cq.java8.lambda;

public class Employ {
	
	private Integer age;
	private Double salary;
	private String name;
	
	public Employ() {
		super();
	}
	public Employ(Integer age, Double salary, String name) {
		super();
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employ [age=" + age + ", salary=" + salary + ", name=" + name + "]";
	}
	
	

}
