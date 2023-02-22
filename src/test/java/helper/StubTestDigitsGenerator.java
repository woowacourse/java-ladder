package helper;

import domain.RandomGenerator;

import java.util.List;

public class StubTestDigitsGenerator implements RandomGenerator {
    private final List<Integer> digits;
    private int index = 0;

    public StubTestDigitsGenerator(List<Integer> digits) {
        this.digits = digits;
    }

    @Override
    public int generate() {
        return digits.get(index++);
    }

}
