package ladder.domain;

public class MockRandomDataGenerator implements RandomGenerator{

    @Override
    public boolean generateBoolean() {
        return false;
    }

    @Override
    public int generateNumber(int min, int max) {
        return 3;
    }
}
