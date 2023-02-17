package helper;

import domain.RandomGenerator;

public class StubPossibleDigitsGenerator implements RandomGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
