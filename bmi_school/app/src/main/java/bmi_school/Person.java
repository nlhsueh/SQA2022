package bmi_school;

public class Person {
	String ssn, name;
	double height, weight;
	double bmi;
	
	public Person(String ssn, String name, double h, double w) {
		this.ssn = ssn;
		this.name = name;
		this.height = h;
		this.weight = w;
		setBMI();
	}
	
	public void setBMI() {
		bmi = weight/(height*height);
	}
	
	public double getBMI() {
		return bmi;
	}
	
	public String toString() {
		return (name + " - " + bmi);
	}
}
