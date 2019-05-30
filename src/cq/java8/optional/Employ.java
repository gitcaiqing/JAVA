package cq.java8.optional;

import java.util.Arrays;
import java.util.List;

public class Employ {
	
	private Integer age;
	private Double salary;
	private String name;
	private List<String> orders = Arrays.asList("aa","bb");
	
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
	
	public List<String> getOrders() {
		return Arrays.asList("aa","bb");
	}
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Employ [age=" + age + ", salary=" + salary + ", name=" + name + ", orders=" + orders + "]";
	}
	
	
	

}
