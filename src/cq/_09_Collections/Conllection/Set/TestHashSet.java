package cq._09_Collections.Conllection.Set;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestHashSet {
	@Test
	public void testHashSet(){
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("h1");
		hashSet.add("h4");
		hashSet.add("h3");
		hashSet.add(new String("hh"));
		hashSet.add(null);
		System.out.println("hashSet:"+hashSet);
		
		Set<Person> p_hashSet = new HashSet<Person>();
		p_hashSet.add(new Person("hcq", 1));
		p_hashSet.add(new Person("hcq2", 2));
		p_hashSet.add(new Person("hcq", 1));
		System.out.println("p_hashSet:"+p_hashSet);
		for(Person p:p_hashSet){
			System.out.println("p_name:"+p.getName()+"--->p_age:"+p.getAge());
		}
	}
}
class Person{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}