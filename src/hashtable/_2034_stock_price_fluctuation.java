package hashtable;

import java.util.*;

public class _2034_stock_price_fluctuation {
}

class StockPrice {
    TreeMap<Integer, Integer> timeMap = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> priceMap = new TreeMap<>();

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if(timeMap.containsKey(timestamp)) {
            int oldPrice = timeMap.get(timestamp);
            priceMap.get(oldPrice).remove(timestamp);
            if(priceMap.get(oldPrice).isEmpty()) {
                priceMap.remove(oldPrice);
            }
        }
        timeMap.put(timestamp, price);
        priceMap.computeIfAbsent(price, e-> new HashSet<>()).add(timestamp);
    }

    public int current() {
        return timeMap.lastEntry().getValue();
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}