package ladder.domain.linegenerator;

import java.util.List;
import java.util.stream.Stream;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public List<Boolean> getLine(int peopleNumber) {
        Boolean before = Boolean.FALSE;

        return Stream.iterate(before, this::nextBoolean)
                .skip(1)
                .limit(peopleNumber-1)
                .toList();
    }

    private Boolean nextBoolean(Boolean before) {
        if (before) {
            before = Boolean.FALSE;
            return false;
        }
        if (Math.random() >= 0.5) {
            before = Boolean.TRUE;
            return true;
        }
        return false;
    }
}
