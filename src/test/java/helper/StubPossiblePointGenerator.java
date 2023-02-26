package helper;

import domain.RandomGenerator;

public class StubPossiblePointGenerator implements RandomGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
