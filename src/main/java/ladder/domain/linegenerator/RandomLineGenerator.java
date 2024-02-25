package ladder.domain.linegenerator;

import java.util.List;
import java.util.stream.Stream;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public List<Boolean> getLine(int peopleNumber) {
        return Stream.iterate(false, this::nextBoolean)
                .skip(1)
                .limit(peopleNumber - 1)
                .toList();
    }

    private boolean nextBoolean(boolean before) {
        if (before) {
            return false;
        }
        return Math.random() >= 0.5;
    }
}
