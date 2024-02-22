package mock;

import domain.BooleanGenerator;

public class TrueGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
