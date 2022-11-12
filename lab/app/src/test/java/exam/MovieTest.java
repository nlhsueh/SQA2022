/**

以下是一個全天電影院收費系統的規則: (1) 一般票價 200 (2) 12-18（ 含）歲學生非假日一般時段 打八折 (3) 非假日早場 4:00-10:00 AM 一般人打七折，學生票只打九折。(4) 假日（週六日）一律250 元。測試應該包含邊界測試的概念，請說明你的邊界測試策略。

請以文字說明測試的重點，並以表格的方式描述測試案例 
撰寫程式碼並用JUnit 進行完整測試，並說明測試結果與你的完成度。

*/

/**
Test policy
Age: 12, 13, 17, 18 are the bounday
Time: 4, 5, 9, 10 are the bounday

We test each partition to meet the week coverage of testing
test Holiday
test Student (age)
    in different time, day
test Morning (time)
    for student, people (not student), 

 */


package exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MovieTest {
	Movie movie;

	@BeforeEach
	void setUp() throws Exception {
		movie = new Movie();
	}

	@DisplayName("Weekend test")
	@ParameterizedTest
	@ValueSource(strings = {"Satursday", "Sunday"})	
	void testWeekend(String day) {
		assertAll("student", 
				() -> {assertEquals(250, movie.price(day, 18, 4));}, 
				() -> {assertEquals(250, movie.price(day, 18, 12));}
		);
		assertAll("not student (people)", 
				() -> {assertEquals(250, movie.price(day, 22, 4));}, 
				() -> {assertEquals(250, movie.price(day, 22, 12));}
		);
	}
	
	@DisplayName("Student test")	
	@ParameterizedTest
	@ValueSource(ints = {12, 13, 15, 17, 18}) // student age
	void testStudent(int age) {
        // Work date, morning, 九折
		assertEquals(180, movie.price("Monday", age, 4));
		assertEquals(180, movie.price("Tuesday", age, 5));
        // Work date, not morning, 八折
		assertEquals(160, movie.price("Monday", age, 11));
		assertEquals(160, movie.price("Tuesday", age, 16));
        // Weekend, price: 250
		assertEquals(250, movie.price("Sunday", age, 4));
		assertEquals(250, movie.price("Sunday", age, 14));
	}

	@DisplayName("People test")	
	@ParameterizedTest
	@ValueSource(ints = {11, 19, 40, 50}) // people age
	void testPeople(int age) {
        // Work date, morning, 七折
		assertEquals(140, movie.price("Monday", age, 4));
		assertEquals(140, movie.price("Tuesday", age, 5));
        // Work date, not morning, 沒有打折
		assertEquals(200, movie.price("Monday", age, 11));
		assertEquals(200, movie.price("Tuesday", age, 16));
        // Weekend, price: 250
		assertEquals(250, movie.price("Sunday", age, 4));
		assertEquals(250, movie.price("Sunday", age, 14));
	}

	@DisplayName("Morning Time test")	
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 9, 10, 6})
	void testMoringTime(int t) {
        // Work date, Student, 九折
		assertEquals(180, movie.price("Monday", 15, t));
		assertEquals(180, movie.price("Monday", 15, t));
        // Work date, people, 七折
		assertEquals(140, movie.price("Monday", 23, t));
		assertEquals(140, movie.price("Monday", 23, t));
        // Weekend, price: 250
		assertEquals(250, movie.price("Sunday", 15, t));
		assertEquals(250, movie.price("Sunday", 23, t));
	}

	@DisplayName("Not Morning Time test")	
	@ParameterizedTest
	@ValueSource(ints = {11, 12, 14, 23})
	void testNotMoringTime(int t) {
        // Work date, Student, 八折
		assertEquals(160, movie.price("Monday", 15, t));
		assertEquals(160, movie.price("Monday", 15, t));
        // Work date, people, no discount
		assertEquals(200, movie.price("Monday", 23, t));
		assertEquals(200, movie.price("Monday", 23, t));
        // Weekend, price: 250
		assertEquals(250, movie.price("Sunday", 15, t));
		assertEquals(250, movie.price("Sunday", 23, t));
	}

}

