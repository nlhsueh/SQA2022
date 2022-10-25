package lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlusTest {
	@Test
	void testOld() {
        Plus p = new Plus();
        assertEquals(12, p.plus(1,11));
	}
}

