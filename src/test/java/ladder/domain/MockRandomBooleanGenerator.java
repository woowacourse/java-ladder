package ladder.domain;

public class MockRandomBooleanGenerator implements RandomGenerator<Boolean>{

    @Override
    public Boolean generate() {
        return false;
    }
}
