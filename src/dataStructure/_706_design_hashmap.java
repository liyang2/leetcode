package dataStructure;
import java.util.*;
public class _706_design_hashmap {
    static class Pair {
        int key;
        int val;
        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private static final int MOD = 2096;
    LinkedList[] arr = new LinkedList[MOD];

    /** Initialize your data structure here. */
    public _706_design_hashmap() {
        for(int i = 0; i < MOD; i++) {
            arr[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = key % MOD;
        boolean found = false;
        LinkedList<Pair> list = (LinkedList<Pair>)arr[idx];
        for(Pair pair: list ) {
            if(pair.key == key) {
                pair.val = value;
                found = true;
                break;
            }
        }
        if(!found) {
            Pair newPair = new Pair(key, value);
            arr[idx].add(newPair);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Pair> list = (LinkedList<Pair>)arr[key % MOD];
        for(Pair pair: list) {
            if(pair.key == key) {
                return pair.val;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = key % MOD;
        Pair target = null;
        LinkedList<Pair> list = (LinkedList<Pair>)arr[idx];
        for(Pair pair: list) {
            if(pair.key == key) {
                target = pair;
                break;
            }
        }
        list.remove(target);
    }
}
