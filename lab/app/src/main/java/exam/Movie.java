package exam;

/**

以下是一個全天電影院收費系統的規則: (1) 一般票價 200 (2) 12-18（ 含）歲學生非假日一般時段 打八折 (3) 非假日早場 4:00-10:00 AM 一般人打七折，學生票只打九折。(4) 假日（週六日）一律250 元。測試應該包含邊界測試的概念，請說明你的邊界測試策略。

請以文字說明測試的重點，並以表格的方式描述測試案例 
撰寫程式碼並用JUnit 進行完整測試，並說明測試結果與你的完成度。
 */

import java.util.Arrays;

public class Movie {
	
	public double price(String day, int age, int time) {
		double price = 0;
		String [] working = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}; 
		boolean isWeekend = !Arrays.asList(working).contains(day);
        boolean isMorning = (time<=10) && (time>=4);
        boolean isStudent = (age<=18) && (age>=12);

		if (isWeekend) {
			price = 250;
		}
		else if (isStudent) {
			if (isMorning) {
				price = 200*0.9;
			}
			else price = 200*0.8;
		}
		else if (isMorning) {
				price = 200*0.7;
		}
		else price = 200;
		
		return price;	 
	}
}