package model;

import java.util.ArrayList;
import java.util.List;

public class BooleansGenerator {

    private final int size;
    private final BooleanGenerator generator;


    public BooleansGenerator(int size, BooleanGenerator generator) {
        this.size = size;
        this.generator = generator;
    }

    public List<Boolean> generateNotConsecutiveTrue() {
        List<Boolean> generated = new ArrayList<>();
        generated.add(generator.generateBoolean());
        for (int i = 0; i < size - 1; i++) {
            boolean value = generator.updateFalseIfTrue(generated.get(i));
            generated.add(value);
        }
        return generated;
    }
}
