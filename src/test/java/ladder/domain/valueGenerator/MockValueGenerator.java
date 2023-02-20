package ladder.domain.valueGenerator;

import java.util.List;

public class MockValueGenerator implements ValueGenerator {

    private final List<Integer> generatedNumber;
    private final List<Boolean> generatedBoolean;

    private int orderOfNumber;
    private int orderOfBoolean;

    public MockValueGenerator(List<Integer> generatedNumber, List<Boolean> generatedBoolean) {
        this.generatedNumber = generatedNumber;
        this.generatedBoolean = generatedBoolean;
    }

    @Override
    public boolean generateBoolean() {
        if (generatedBoolean.size() == orderOfBoolean) {
            orderOfBoolean = 0;
        }
        return generatedBoolean.get(orderOfBoolean++);
    }

    @Override
    public int generateNumber(int min, int max) {
        if (generatedNumber.size() == orderOfNumber) {
            orderOfNumber = 0;
        }
        return generatedNumber.get(orderOfNumber++);
    }
}
