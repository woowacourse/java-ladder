package ladder.domain;

import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_RANGE = 2;
    private List<Integer> inputs;
    private int index;

    public RandomGenerator() {
        index = 0;
    }

    public RandomGenerator(List<Integer> numbers) {
        this.inputs = numbers;
        index = 0;
    }

    public int getElement() {
        if (inputs == null) {
            return new Random().nextInt(RANDOM_RANGE);
        }
        return inputs.get(index++);
    }
}
