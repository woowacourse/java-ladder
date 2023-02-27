package util;

import java.util.ArrayList;
import java.util.List;

public class TestGenerator implements BooleanGenerator{
    List<Boolean> order = new ArrayList<>();

    public void addAll(List<Boolean> custom){
        order.addAll(custom);
    }

    @Override
    public boolean generate() {
        boolean current = order.get(0);
        order.remove(0);
        return current;
    }
}
