package ladder.domain.valueGenerator;

import ladder.domain.valueGenerator.ValueGenerator;

public class MockValueDataGenerator implements ValueGenerator {

    @Override
    public boolean generateBoolean() {
        return false;
    }

    @Override
    public int generateNumber(int min, int targetValue) {
        return targetValue;
    }
}
