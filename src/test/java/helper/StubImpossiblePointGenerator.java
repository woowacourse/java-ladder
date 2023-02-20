package helper;

import domain.RandomGenerator;

public class StubImpossiblePointGenerator implements RandomGenerator {
    @Override
    public boolean generate() {
        return false;
    }
}
