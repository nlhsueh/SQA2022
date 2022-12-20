package stock;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class MarketTest {
   App app;
   
   Market market;   
   StockService stockService;
          
   @BeforeEach   
   public void setUp(){
      //建立受測物件      
       market = new Market();       
  
      //建立股票服務的 mock 物件
      stockService = mock(StockService.class);      
  
      //把股票服務加入 market 中
      market.setStockService(stockService);
   }

   @Test   
   public void testMarketValue(){          
      //建立一些測試資料（股票）
      List<Stock> stocks = new ArrayList<Stock>();
      Stock googleStock = new Stock("US.GOOG","Google", 10);
      Stock microsoftStock = new Stock("US.MSFT","Microsoft",100);    
      stocks.add(googleStock);
      stocks.add(microsoftStock);

      //把股票加入 market
      market.setStocks(stocks);

      //模擬股票服務的行為，回傳假設的價格
      //這個動作叫 stub（佈樁）
      when(stockService.getPrice(googleStock))
         .thenReturn(50.00);
      when(stockService.getPrice(microsoftStock))
         .thenReturn(1000.00);      

      double marketValue = market.getMarketValue();     
      assertEquals(100500.0, marketValue, 0);
   }

   @Test   
   public void testMarketValue2(){          
      List<Stock> stocks = new ArrayList<Stock>();
      Stock googleStock = new Stock("US.GOOG","Google", 120);
      Stock microsoftStock = new Stock("US.MSFT","Microsoft",150);    
      stocks.add(googleStock);
      stocks.add(microsoftStock);

      //把股票加入 market
      market.setStocks(stocks);

      //模擬股票服務的行為，回傳假設的價格
      //這個動作叫 stub（佈樁）
      when(stockService.getPrice(googleStock))
         .thenReturn(10.0);
      when(stockService.getPrice(microsoftStock))
         .thenReturn(20.0);      

      double marketValue = market.getMarketValue();     
      assertEquals(4200.0, marketValue, 0);
   }

}