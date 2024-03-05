package support;

import generator.BooleanGenerator;

public class TrueOnlyGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return true;
    }
}
