package math;


import java.util.ArrayList;
import java.util.List;

public class _118_pascal_triangle_i {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);

        for(int i = 1; i < numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for(int j = 1; j < list.size(); j++) {
                newList.add(list.get(j-1) + list.get(j));
            }
            newList.add(1);
            res.add(newList);
            list = newList;
        }
        return res;

    }
}
