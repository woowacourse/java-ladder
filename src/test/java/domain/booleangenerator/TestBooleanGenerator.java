package domain.booleangenerator;

import java.util.List;

public class TestBooleanGenerator implements BooleanGenerator {

    private final List<Boolean> numbers;

    public TestBooleanGenerator(List<Boolean> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean generate() {
        return numbers.remove(0);
    }
}
