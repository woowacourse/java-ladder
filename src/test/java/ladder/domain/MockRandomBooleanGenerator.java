package ladder.domain;

public class MockRandomBooleanGenerator implements RandomGenerator {

    @Override
    public boolean generate() {
        return true;
    }

}
