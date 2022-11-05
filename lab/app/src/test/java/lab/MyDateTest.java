package lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.*;
import java.time.temporal.ChronoUnit;

class MyDateTest {

	@Test
	void testToString() {
        MyDate d = new MyDate(2000, "1", 20);
        assertEquals("2000-1-20", d.toString());
	}

	@ParameterizedTest
    @CsvSource({
        "1900, 1, 20, 19",
        "1900, 2, 20, 50",
        "1900, 3, 20, 78",
        "1900, 4, 20, 109",
        "1900, 5, 20, 139",
        "1900, 6, 20, 170",
        "1900, 7, 20, 200",
        "1900, 8, 20, 231",
        "1900, 9, 20, 262",
        "1900, 10, 20, 292",
        "1900, 11, 20, 323",
        "1900, 12, 20, 353"
    })	
    void testDiff1900_same_year(int y, int m, int d, int diff) {
        int _diff = MyDate.diff1900(new MyDate(y, m, d));
        assertEquals(diff, _diff);
	}

	@ParameterizedTest
    @CsvSource({
        "1900, 1, 20, 19",
        "1900, 2, 20, 50",
        "1900, 3, 20, 78",
        "1900, 4, 20, 109",
        "1900, 5, 20, 139",
        "1900, 6, 20, 170",
        "1900, 7, 20, 200",
        "1900, 8, 20, 231",
        "1900, 9, 20, 262",
        "1900, 10, 20, 292",
        "1900, 11, 20, 323",
        "1900, 12, 20, 353"
    })	
    void testDiff11_same_year(int y, int m, int d, int diff) {
        int _diff = MyDate.diff11(new MyDate(y, m, d));
        assertEquals(diff, _diff);
	}

    @ParameterizedTest
    @CsvSource({
        "1901, 1, 1",
        "1901, 2, 1",
        "1901, 3, 1",
        "1901, 3, 20",
        "1902, 1, 1",
        "1903, 1, 1",
        "1904, 1, 1",
        "1905, 10, 1",
        "2000, 1, 1",
    })	
    void testDiff_cross_year(int y, int m, int d) {
        long _diff = MyDate.diff1900(new MyDate(y, m, d));
        long java_date = ChronoUnit.DAYS.between(LocalDate.of(1900, 1, 1), LocalDate.of(y,m,d));

        assertEquals(java_date, _diff);
	}

    @ParameterizedTest
    @CsvSource({
        "1901, 1, 1, 1901, 1, 2",
        "1901, 2, 28, 1901, 3, 1",
        "2000, 2, 28, 2000, 2, 29",
        "2000, 12, 31, 2001, 1, 1",
        "2000, 6, 30, 2000, 7, 1",
        "2000, 7, 30, 2000, 7, 31",
    })	
    void testTomorrow(int y1, int m1, int d1, int y2, int m2, int d2) {
        MyDate today = new MyDate(y1, m1, d1);
        MyDate expected_tomorrow = new MyDate(y2, m2, d2);        
        assertEquals(expected_tomorrow.toString(), today.tomorrow().toString());
	}

    @Test
    void testJavaAPI() {
        LocalDate d1 = LocalDate.of(1900, 1, 1);
        LocalDate d2 = LocalDate.of(1901, 1, 1);
        long daysBetween = ChronoUnit.DAYS.between(d1, d2);

        System.out.println(daysBetween);
    }


}

