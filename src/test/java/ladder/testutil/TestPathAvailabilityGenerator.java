package ladder.testutil;

import ladder.domain.generator.PathAvailabilityGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TestPathAvailabilityGenerator implements PathAvailabilityGenerator {

    private final Iterator<Boolean> pathAvailabilities;

    public TestPathAvailabilityGenerator(final List<Boolean> pathAvailabilities) {
        this.pathAvailabilities = pathAvailabilities.iterator();
    }

    @Override
    public boolean generate() {
        if (pathAvailabilities.hasNext()) {
            return pathAvailabilities.next();
        }
        throw new NoSuchElementException("이미 모든 pathAvailability가 반환되었습니다.");
    }
}
