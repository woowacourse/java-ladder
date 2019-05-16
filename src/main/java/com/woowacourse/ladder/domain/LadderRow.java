package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderRow<T> {
    private final List<Boolean> cols;

    public LadderRow(final int numOfColumns, final BooleanGenerator booleanGenerator) {
        cols = new ArrayList<>(numOfColumns);
        for (int i = 0; i < numOfColumns; i++) {
            cols.add(false);
        }
        createRow(booleanGenerator);
    }

    private void createRow(BooleanGenerator generator) {
        cols.set(0, generator.generateBoolean());
        for (int i = 1; i < cols.size(); i++) {
            boolean b = generator.generateBoolean();
            if (cols.get(i - 1)) {
                cols.set(i, false);
                continue;
            }
            cols.set(i, b);
        }
    }

    public ParticipantGroup<T> swapNames(ParticipantGroup<T> participantGroup) {
        for (int i = 0; i < cols.size(); i++) {
            participantGroup = checkAndSwap(participantGroup, i);
        }

        return participantGroup;
    }

    private ParticipantGroup<T> checkAndSwap(ParticipantGroup<T> participantGroup, int idx) {
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
