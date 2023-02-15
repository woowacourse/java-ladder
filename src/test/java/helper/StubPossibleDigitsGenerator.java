package helper;

import domain.RandomGenerator;

public class StubPossibleDigitsGenerator implements RandomGenerator {
    @Override
    public int generate() {
        return 1;
    }
}
