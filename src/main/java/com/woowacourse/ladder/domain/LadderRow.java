package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderRow {
    private final List<Boolean> cols;

    LadderRow(final int numOfColumns, final BooleanGenerator booleanGenerator) {
        cols = new ArrayList<>(numOfColumns);
        createRow(booleanGenerator, numOfColumns);
    }

    private void createRow(BooleanGenerator generator, int numOfColumns) {
        boolean lastGenerated = generator.generateBoolean();
        cols.add(lastGenerated);
        for (int i = 1; i < numOfColumns; i++) {
            lastGenerated = checkAndAddColumn(generator, lastGenerated);
        }
    }

    private boolean checkAndAddColumn(BooleanGenerator generator, boolean lastGenerated) {
        boolean b = generator.generateBoolean();
        if (lastGenerated) {
            cols.add(false);
            return false;
        }
        cols.add(b);
        return b;
    }

    ParticipantGroup swapNames(ParticipantGroup participantGroup) {
        for (int i = 0; i < cols.size(); i++) {
            participantGroup = checkAndSwap(participantGroup, i);
        }

        return participantGroup;
    }

    private ParticipantGroup checkAndSwap(ParticipantGroup participantGroup, int idx) {
        if (cols.get(idx)) {
            participantGroup = participantGroup.swap(idx, idx + 1);
        }

        return participantGroup;
    }

    public Stream<Boolean> getColumnStream() {
        return cols.stream();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        cols.stream()
            .map(b -> b ? "■" : "□")
            .forEach(sb::append);
        sb.append(']');
        return sb.toString();
    }
}
