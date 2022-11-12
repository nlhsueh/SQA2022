
/**
2020-2021 年台灣股市大漲，小明分別買進若干的台積電股票。以下程式 profit 會計算小明的獲利，其中 currentPrice 表示台積電目前的股價; buy[] 表示過去買台積電的股價，例如 {200, 400, 450, 600} 表示共買了四張的股票。 另，股價應該在 200-1000 之間，若超出範圍請拋出例外。

 double profit(double currentPrice, double buy[])

請以文字模式說明測試的重點，並以類表格的方式描述測試案例 
撰寫程式碼並用JUnit 進行完整測試，並說明測試結果與你的完成度
 */

package exam;

import java.util.Arrays;

public class Stock {
	
	public double profit(double currentPrice, double buy[]) throws Exception {
        double p=0;

        if (!(currentPrice <= 1000 && currentPrice >= 200))
            throw new Exception("Over price");
        for (double b: buy) {
            if (!(b <= 1000 && b >= 200)) 
                throw new Exception("Over price");
            p += (currentPrice - b);
        }

        return p*1000;
	}
}