package ladder;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ladder.domain.ladder.Rung;
import ladder.domain.ladder.RungGenerator;

public class MockRungGenerator implements RungGenerator {

    private final Iterator<Rung> mockedRungs;

    public MockRungGenerator(Iterable<Rung> mockedStatus) {
        this.mockedRungs = mockedStatus.iterator();
    }

    @Override
    public Rung getRandomStatusRung() {
        if (!mockedRungs.hasNext()) {
            throw new NoSuchElementException("다음 Mock 데이터를 찾을 수 없습니다.");
        }
        return mockedRungs.next();
    }
}
