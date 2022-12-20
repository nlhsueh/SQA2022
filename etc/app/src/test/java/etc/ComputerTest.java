package etc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class ComputerTest {

	// @Test
	// void testDiv01() {
    //     assertEquals(2, Computer.div(4, 2));
	// }

	@Test
	void testDiv02() throws Exception {
        assertEquals(2, Computer.div(4, 2));
	}

	@Test
	void testDiv03()  {
        assertThrows(Exception.class, ()-> Computer.div(4, 0));
	}

	@Test
	void testDiv04() throws Exception {
        assertThrows(Exception.class, Computer.div(4, 0));
	}
}

