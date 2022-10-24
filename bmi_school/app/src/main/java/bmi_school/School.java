package bmi_school;

import java.util.ArrayList;

public class School {
	
	ArrayList<Person> students = new ArrayList<Person>();
	double over, under;
	
	public void addStudent(Person p) {
		students.add(p);
	}
	
	public void setBMILevel(double over, double under) {
		this.over = over;
		this.under = under;
	}
	
	public String[] needExercise() {
		ArrayList<String> needExercise = new ArrayList<String>();
		for (Person p: students) {
			if (p.getBMI() > over) {
				needExercise.add(p.ssn);
				System.out.println(p);
			}
		}
		String[] needExerciseSSN = new String[needExercise.size()];
		needExercise.toArray(needExerciseSSN);
		return (needExerciseSSN);		
	}
	
	public String[] needEatMore() {
		ArrayList<String> needEatMore = new ArrayList<String>();
		for (Person p: students) {
			if (p.getBMI() < under) {
				needEatMore.add(p.ssn);
				System.out.println(p);
			}
		}
		String[] needEatMoreSSN = new String[needEatMore.size()];
		needEatMore.toArray(needEatMoreSSN);
		return needEatMoreSSN;				
	}
	
	public ArrayList<Person> fatStudents() {
		ArrayList<Person> fat = new ArrayList<Person>();
		for (Person p: students) {
			if (p.getBMI() > over) {
				fat.add(p);
			}
		}		
		return fat;		
	}

}
