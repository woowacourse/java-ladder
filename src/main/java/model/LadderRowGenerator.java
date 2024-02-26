package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRowGenerator implements BooleansGenerator {

    private final int size;
    private final BooleanGenerator generator;


    public LadderRowGenerator(int size, BooleanGenerator generator) {
        this.size = size;
        this.generator = generator;
    }

    @Override
    public List<Boolean> generateNotConsecutiveTrue() {
        List<Boolean> generated = new ArrayList<>();
        generated.add(new Random().nextBoolean());
        for (int i = 0; i < size - 2; i++) {
            boolean value = generator.updateFalseIfTrue(generated.get(i));
            generated.add(value);
        }
        return generated;
    }
}
