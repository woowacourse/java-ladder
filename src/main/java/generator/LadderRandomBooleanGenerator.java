package generator;

import java.util.Random;

public class LadderRandomBooleanGenerator implements BooleanGenerator {

    private boolean previous = false;
    private final Random random = new Random();

    @Override
    public boolean generate() {
        boolean generated = random.nextBoolean();
        if (previous) {
            generated = false;
        }
        previous = generated;
        return generated;
    }
}
