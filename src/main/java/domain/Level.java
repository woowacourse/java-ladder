package domain;

import util.StoolGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level {
    private final List<Stool> stools;

    public Level(int participantsSize, StoolGenerator stoolGenerator) {
        this.stools = initLine(participantsSize);
        makeStools(stoolGenerator);
    }

    private List<Stool> initLine(int participantSize) {
        final int COLUMN_SIZE = participantSize - 1;

        return Stream.generate(() -> Stool.EMPTY)
                .limit(COLUMN_SIZE)
                .collect(Collectors.toList());
    }

    private void makeStools(StoolGenerator stoolGenerator) {
        for (int i = 0; i < stools.size(); i++) {
            makeStool(i, stoolGenerator);
        }
    }

    private void makeStool(int index, StoolGenerator stoolGenerator) {
        if (index == 0) {
            stools.set(0, stoolGenerator.next());
            return;
        }

        final int PREVIOUS = index - 1;
        if (!stools.get(PREVIOUS).isExist()) {
            stools.set(index, stoolGenerator.next());
        }
    }

    public int size() {
        return stools.size();
    }

    public List<Stool> getStools() {
        return Collections.unmodifiableList(stools);
    }
}
