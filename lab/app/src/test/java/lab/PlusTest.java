package lab;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

class PlusTest {

	@Test
	void test_plus() {
        Plus p = new Plus();
        assertEquals(12, p.plus(1,11));
	}

	@Test
	void test_plus_by_lazy_evaluation() {
        Plus p = new Plus();
        assertEquals(12, p.plus(1,11), ()-> "Plus fail");
	}

	@Test
	void test_plus_by_assertAll() {
        Plus p = new Plus();
	    assertAll("positive plus",
            () -> assertEquals(12, p.plus(1,11)),
            () -> assertEquals(111, p.plus(100,11))
        );
		assertAll("positive plus negative",
            () -> assertEquals(10, p.plus(-1,11)),
            () -> assertEquals(10, p.plus(11,-1))
        );
	}	

	@Test
	void test_timeout() {
		Plus p = new Plus();

     	int r = assertTimeout(Duration.ofMinutes(2), () -> {
			return p.plus(11, -1);
		});
     	assertEquals(10, r);
	}

	@DisplayName("Testing positive number + negative number")
	@Test
	void test_positive_plus_negative() {
        Plus p = new Plus();
        assertEquals(10, p.plus(-1,11));
	}	

	void test_positive_plus_negative2() {
        Plus p = new Plus();
        assertEquals(10, p.plus(-1,11));
	}	


}

