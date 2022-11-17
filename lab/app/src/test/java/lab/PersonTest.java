package lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test_person() {
        Person p = new Person("Nick", "Hsueh");

	    assertAll("Person test",
            () -> { // first name
                String fname = p.getFirstName();

                assertNotNull(fname);

                assertAll("First name", 
                    () -> assertTrue(fname.startsWith("N")),
                    () -> assertTrue(fname.endsWith("k"))
                );    
            },

            () -> { // last name
                String lname = p.getLastName();

                assertNotNull(lname);

                assertAll("Last name", 
                    () -> assertTrue(lname.startsWith("H")),
                    () -> assertTrue(lname.endsWith("h"))
                );    
            }		    
        );
	}

}

