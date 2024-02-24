package ladder;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ladder.domain.randomGenerator.RungGenerator;

public class MockBooleanGenerator implements RungGenerator {

    private final Iterable<Boolean> mockStatus;
    private final Iterator<Boolean> iterator;

    public MockBooleanGenerator(Iterable<Boolean> mockStatus) {
        this.mockStatus = mockStatus;
        this.iterator = mockStatus.iterator();
    }

    @Override
    public boolean getRandomBooleanStatus() {
        if (!iterator.hasNext()) {
            throw new NoSuchElementException("mock 인덱스를 넘어섰습니다.");
        }
        return iterator.next();
    }
}
