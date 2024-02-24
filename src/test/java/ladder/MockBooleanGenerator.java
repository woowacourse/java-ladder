package ladder;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ladder.domain.Rung;
import ladder.domain.randomGenerator.RungGenerator;

public class MockBooleanGenerator implements RungGenerator {

    private final Iterator<Rung> mockedRungs;

    public MockBooleanGenerator(Iterable<Rung> mockedStatus) {
        this.mockedRungs = mockedStatus.iterator();
    }

    @Override
    public Rung getRandomStatusRung() {
        if (!mockedRungs.hasNext()) {
            throw new NoSuchElementException("mock 리스트 인덱스를 넘어섰습니다.");
        }
        return mockedRungs.next();
    }
}
