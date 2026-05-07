package Assignment8;

import java.util.HashMap;

public class StockMap {
    
    private HashMap<String, Stock> map = new HashMap<>();

    public void addStock(String symbol, Stock stock){
        map.put(symbol, stock);
    }

    public Stock geStock(String symbol){
        return map.get(symbol);
    }

        //demo
        public static void main(String[] args){

        Stock stock1 = new Stock("a", 100);
        Stock stock2 = new Stock("b", 1000);
        Stock stock3 = new Stock("c", 250);
        Stock stock4 = new Stock("d", 245.23);

        StockMap stockMap = new StockMap();

        stockMap.addStock("a", stock1);
        stockMap.addStock("b", stock2);
        stockMap.addStock("c", stock3);
        stockMap.addStock("d", stock4);

        System.out.println(stockMap.geStock("a"));
        System.out.println(stockMap.geStock("c"));
        System.out.println(stockMap.geStock("z"));
    }
}
