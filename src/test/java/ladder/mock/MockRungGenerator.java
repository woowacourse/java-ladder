package ladder.mock;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.ladder.Rung;
import ladder.domain.ladder.generator.RungGenerator;

public class MockRungGenerator implements RungGenerator {
    private final List<Rung> rungs;
    private int currentIndex = 0;

    public MockRungGenerator(List<Rung> rungs) {
        this.rungs = new ArrayList<>(rungs);
    }

    @Override
    public Rung generate() {
        if (currentIndex >= rungs.size()) {
            throw new IllegalStateException("더 이상 생성할 수 없습니다.");
        }
        return rungs.get(currentIndex++);
    }
}
