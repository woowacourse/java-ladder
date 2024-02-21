package generator;

public class LadderBooleanGenerator implements BooleanGenerator {

    private final BooleanGenerator generator;
    private boolean previous = false;

    public LadderBooleanGenerator(BooleanGenerator generator) {
        this.generator = generator;
    }

    @Override
    public boolean generate() {
        boolean generated = generator.generate();
        if (previous) {
            generated = false;
        }
        previous = generated;
        return generated;
    }
}
