
/**
2020-2021 年台灣股市大漲，小明分別買進若干的台積電股票。以下程式 profit 會計算小明的獲利，其中 currentPrice 表示台積電目前的股價; buy[] 表示過去買台積電的股價，例如 {200, 400, 450, 600} 表示共買了四張的股票。 另，股價應該在 200-1000 之間，若超出範圍請拋出例外。

 double profit(double currentPrice, double buy[])

請以文字模式說明測試的重點，並以類表格的方式描述測試案例 
撰寫程式碼並用JUnit 進行完整測試，並說明測試結果與你的完成度
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

class StockTest {
	Stock stock;

	@BeforeEach
	void setUp() throws Exception {
		stock = new Stock();
	}
	
    @Test
	void testStock() throws Exception {
		assertEquals(0, stock.profit(250, new double[] {250}));
		assertEquals(200*1000, stock.profit(350, new double[] {250, 250}));
		assertEquals(0, stock.profit(350, new double[] {250, 450}));
	}

    @Test
	void testStockException() throws Exception {
		assertThrows(Exception.class, () -> stock.profit(1250, new double[] {250}));
		assertThrows(Exception.class, () -> stock.profit(100, new double[] {250}));
		assertThrows(Exception.class, () -> stock.profit(250, new double[] {150}));
		assertThrows(Exception.class, () -> stock.profit(250, new double[] {1150}));
	}

}

