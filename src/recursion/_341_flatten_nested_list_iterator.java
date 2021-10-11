package recursion;

import java.util.*;

public class _341_flatten_nested_list_iterator {
}

interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    Iterator<Integer> iter = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger ni : nestedList) {
            dfs(ni);
        }
        iter = list.iterator();
    }
    private void dfs(NestedInteger ni) {
        if(ni.isInteger()) {
            list.add(ni.getInteger());
        } else {
            for(NestedInteger nint : ni.getList()) {
                dfs(nint);
            }
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}
