package ladder.domain.linegenerator;

import java.util.Random;
import java.util.function.IntSupplier;

public class RandomBinarySupplier implements IntSupplier {

    private static final Random RANDOM = new Random();

    @Override
    public int getAsInt() {
        return RANDOM.nextInt(2);
    }
}
