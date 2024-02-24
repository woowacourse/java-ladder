package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.randomGenerator.RungGenerator;

public class MockBooleanGenerator implements RungGenerator {

    private final List<Boolean> mockStatus;
    public int currentIdx = 0;

    public MockBooleanGenerator(List<Boolean> mockStatus) {
        this.mockStatus = new ArrayList<>(mockStatus);
    }

    @Override
    public boolean getRandomBooleanStatus() {
        if (currentIdx >= mockStatus.size()) {
            throw new IllegalArgumentException("mock 현재 인덱스가 최대 범위를 벗어났습니다.");
        }
        return mockStatus.get(currentIdx++);
    }
}
