package util;

import domain.Scaffold;
import domain.ScaffoldGenerator;
import java.util.List;

public class TestScaffoldGenerator implements ScaffoldGenerator {
    private List<Boolean> booleans;
    private int index = 0;

    public TestScaffoldGenerator(final List<Boolean> booleans) {
        this.booleans = booleans;
    }

    @Override
    public Scaffold generate() {
        if (booleans.get(index++)) {
            return Scaffold.EXIST;
        }
        return Scaffold.NONE;
    }

}
