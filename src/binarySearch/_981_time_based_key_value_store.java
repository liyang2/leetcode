package binarySearch;
import java.util.*;
public class _981_time_based_key_value_store {
}

class TimeMap {

    Map<String, List<Item>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, e -> new ArrayList<>())
                .add(new Item(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        List<Item> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp > timestamp) {
                right = mid;
            } else if (list.get(mid).timestamp < timestamp) {
                left = mid;
            } else {
                return list.get(mid).value;
            }
        }
        if (list.get(right).timestamp <= timestamp)
            return list.get(right).value;
        if (list.get(left).timestamp <= timestamp)
            return list.get(left).value;
        return "";
    }
}

class Item {
    String value;
    int timestamp;
    public Item(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */