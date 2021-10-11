package dataStructure;

import java.util.*;

public class _380_insert_delete_getRandom {
}

class RandomizedSet {
    Random random;
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    public RandomizedSet() {
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int lastEleVal = list.get(list.size()-1);
        int curValIndex = map.get(val);

        list.set(curValIndex, lastEleVal);
        map.put(lastEleVal, curValIndex);

        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}