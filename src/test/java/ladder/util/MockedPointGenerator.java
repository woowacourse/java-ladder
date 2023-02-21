package ladder.util;

import ladder.domain.RandomGenerator;

import java.util.List;

public class MockedPointGenerator implements RandomGenerator<Boolean> {

    private final List<Boolean> dummy;
    private int index = 0;

    public MockedPointGenerator(final List<Boolean> dummy) {
        this.dummy = dummy;
    }

    @Override
    public Boolean generate() {
        return dummy.get(index++);
    }

}
