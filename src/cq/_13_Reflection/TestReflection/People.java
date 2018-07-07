package cq._13_Reflection.TestReflection;

public class People<T> {
	public String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "People [country=" + country + "]";
	}

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public People(String country) {
		super();
		this.country = country;
	}
	
	private void fahaha(){
		System.out.println("fahaha");
		
	}
}
