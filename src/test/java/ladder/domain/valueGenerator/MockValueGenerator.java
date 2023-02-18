package ladder.domain.valueGenerator;

public class MockValueGenerator implements ValueGenerator {

    @Override
    public boolean generateBoolean() {
        return false;
    }

    @Override
    public int generateNumber(int min, int targetValue) {
        return targetValue;
    }
}
