package domain;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class TestBooleanGenerator implements BooleanGenerator {

    private final List<Boolean> generateValues = new ArrayList<>();

    public void addOrderedValues(List<Boolean> orderedValue) {
        generateValues.addAll(orderedValue);
    }

    @Override
    public boolean generate() {
        Boolean currentValue = generateValues.get(0);
        generateValues.remove(0);
        return currentValue;
    }
}
