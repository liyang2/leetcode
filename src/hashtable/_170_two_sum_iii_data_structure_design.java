package hashtable;

import java.util.HashMap;
import java.util.Map;

public class _170_two_sum_iii_data_structure_design {
    public static void main(String[] args) {
        _170_two_sum_iii_data_structure_design s = new _170_two_sum_iii_data_structure_design();
        s.add(0);
        System.out.println(s.find(0));
    }

    Map<Integer, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public _170_two_sum_iii_data_structure_design() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int num1 : map.keySet()) {
            int num2 = value - num1;
            if(num1 == num2 && map.get(num1) >= 2) {
                return true;
            } else if(num1 != num2 && map.containsKey(num2)) {
                return true;
            }
        }
        return false;
    }
}
