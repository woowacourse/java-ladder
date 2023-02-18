package domain;

import util.StoolGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Level {
    private final List<Stool> level;

    public Level(int participantsSize, StoolGenerator stoolGenerator) {
        this.level = initLine(participantsSize);
        makeStools(stoolGenerator);
    }

    private List<Stool> initLine(int participantSize) {
        return Stream.generate(() -> Stool.EMPTY)
                .limit(participantSize - 1)
                .collect(Collectors.toList());
    }

    private void makeStools(StoolGenerator stoolGenerator) {
        level.set(0, stoolGenerator.next());

        IntStream.range(0, level.size() - 1)
                .forEach(index -> makeStool(index, stoolGenerator));
    }

    private void makeStool(int index, StoolGenerator stoolGenerator) {
        if (!level.get(index).isExist()) {
            level.set(index + 1, stoolGenerator.next());
        }
    }

    public int size() {
        return level.size();
    }

    public List<Stool> getStools() {
        return Collections.unmodifiableList(level);
    }
}
