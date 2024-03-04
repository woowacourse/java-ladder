package support;

import domain.booleanGenerator.BooleanGenerator;

public class TrueGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
