package model;

public class LadderRowGenerator {

    private final BooleanGenerator generator;

    public LadderRowGenerator(BooleanGenerator generator) {
        this.generator = generator;
    }

    public boolean generate(boolean isTrue) {
        if (isTrue) {
            return false;
        }
        return generator.generator();
    }
}
