package cq.java8.optional;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Optional;

public class TestOptional {

	public static Employ getE() {
		Employ employ = new Employ(1, 22d, "cc");	
		employ = null;
		Optional<Employ> optionalEmploy = Optional.ofNullable(employ);
		return optionalEmploy.orElseThrow(()-> new RuntimeException());
	}
	
	public static void main(String[] args) {
		Employ employ = new Employ(1, 22d, "cc");	
		//employ = null; dwo 
		String username = Optional.ofNullable(employ).map(e -> e.getName()).orElse(null);
		System.out.println("username:"+username);
		
		String username2 = Optional.ofNullable(employ).filter(e -> e.getAge() > 10).map(e -> e.getName()).orElse(null);
		System.out.println("username2:"+username2);
		
		Employ eget = getE();
		System.out.println(eget);
		
		//Optional<Employ> optionalEmploy = Optional.ofNullable(employ);
		//optionalEmploy.ifPresent((e) -> System.out.println(e.getName()));
		//System.out.println("----------------");
		
		//System.out.println(employ.getName());
		
		
//		Employ e = new Employ(1, 22d, "cc");	
//		e = null;
//		Optional<Employ> employ = Optional.ofNullable(e);
//		
//		System.out.println(employ.orElse(null));
//		
//		System.out.println(employ.orElseGet(()-> new Employ(2, 2233d, "c32c")));
//		
//		System.out.println( employ.map(a -> a.getOrders()).orElse(Collections.emptyList()) );
		
		
	}
	
}
