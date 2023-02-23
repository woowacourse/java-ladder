package domain;

import java.util.List;
import utils.NumberGenerator;

/**
 * 생성자를 통해 특정한 숫자값을 순서대로 반환하는 NumberGenerator
 */
public class MockNumberGenerator implements NumberGenerator {

    private final List<Integer> values;
    private int index = 0;

    public MockNumberGenerator(List<Integer> values) {
        this.values = values;
    }

    @Override
    public int generate() {
        Integer value = values.get(index);
        index++;
        if (index >= values.size()) {
            index = 0;
        }
        return value;
    }
}