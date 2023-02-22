package ladder.domain.generator;

import java.util.List;

public class MockBooleanGenerator implements BooleanGenerator {

    private final List<Boolean> generatedBoolean;

    private int orderOfBoolean;

    public MockBooleanGenerator(List<Boolean> generatedBoolean) {
        this.generatedBoolean = generatedBoolean;
    }

    @Override
    public boolean generateBoolean() {
        if (generatedBoolean.size() == orderOfBoolean) {
            orderOfBoolean = 0;
        }
        return generatedBoolean.get(orderOfBoolean++);
    }

}
