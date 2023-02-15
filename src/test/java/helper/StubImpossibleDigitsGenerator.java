package helper;

import domain.RandomGenerator;

public class StubImpossibleDigitsGenerator implements RandomGenerator {
    @Override
    public int generate() {
        return 0;
    }
}
