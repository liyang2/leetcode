package math;

import java.util.*;

public class _119_pascal_triangle_ii {

    public static void main(String[] args) {
        new _119_pascal_triangle_ii().getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        if(rowIndex == 0) return list;

        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            for(int j = 1; j < list.size(); j++) {
                newList.add(list.get(i) + list.get(i-1));
            }
            newList.add(1);
            list = newList;
        }
        return list;
    }
}
