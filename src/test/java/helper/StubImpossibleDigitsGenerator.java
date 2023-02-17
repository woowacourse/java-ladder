package helper;

import domain.RandomGenerator;

public class StubImpossibleDigitsGenerator implements RandomGenerator {
    @Override
    public boolean generate() {
        return false;
    }
}
