package recursion;

import pojos.Employee;
import java.util.*;

public class _690_employee_importance {
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for(Employee e: employees) {
            map.put(e.id, e);
        }
        return getImportance(id);
    }

    int getImportance(int id) {
        Employee e = map.get(id);
        int res = e.importance;
        for(int sub: e.subordinates) {
            res += getImportance(sub);
        }
        return res;
    }
}
