package test.linegenerator;

import ladder.domain.linegenerator.LineGenerator;

import java.util.List;
import java.util.stream.Stream;

public class AlternativeLineGenerator implements LineGenerator {
    @Override
    public List<Boolean> getLine(int peopleNumber) {
        return Stream.iterate(false, this::nextBoolean)
                .skip(1)
                .limit(peopleNumber - 1)
                .toList();
    }

    private boolean nextBoolean(boolean before) {
        return !before;
    }
}
