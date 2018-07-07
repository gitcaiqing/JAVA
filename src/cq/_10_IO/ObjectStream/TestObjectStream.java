package cq._10_IO.ObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/**
 * 对象流
 * 对象序列化过程：将对象转成平台无关的二进制流，二进制流可以还原为原来的对象
 * @author Administrator
 *
 */
public class TestObjectStream {

	
	/**
	 * 对象转为二进制流即对象的序列化过程
	 * ObjectOutputStream
	 */
	@Test
	public void objectOutputStream(){
		Person p1 = new Person("我爱你", 18);
		Person p2 = new Person("你爱我", 16);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("objectStream.txt"));
			
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 将二进制流还原为对象即对象的反序列化过程
	 * ObjectInputStream
	 */
	@Test
	public void objInputStream(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("objectStream.txt"));
			Person p1 = (Person) ois.readObject();
			System.out.println("p1:"+p1);
			Person p2 = (Person) ois.readObject();
			System.out.println("p2:"+p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}

class Person implements Serializable{
	
	//版本号
	private static final long serialVersionUID = 1L;
	
	String name;
	Integer age;
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
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
	
	
}

