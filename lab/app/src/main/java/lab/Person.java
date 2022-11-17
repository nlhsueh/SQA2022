package lab;

public class Person {
    String fname, lname;

    public Person(String firstName, String lastName) {
        this.fname = firstName;
        this.lname = lastName;
    }

    public String getFirstName() {
        return fname;
    }

    public String getLastName() {
        return lname;
    }
}