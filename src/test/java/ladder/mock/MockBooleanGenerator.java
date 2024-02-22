package ladder.mock;

import ladder.domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class MockBooleanGenerator implements BooleanGenerator {
    private final List<Boolean> rungs;
    private int currentIndex = 0;

    public MockBooleanGenerator(List<Boolean> rungs) {
        this.rungs = new ArrayList<>(rungs);
    }

    @Override
    public boolean generate() {
        if (currentIndex >= rungs.size()) {
            throw new IllegalStateException("더 이상 생성할 수 없습니다.");
        }
        return rungs.get(currentIndex++);
    }
}
