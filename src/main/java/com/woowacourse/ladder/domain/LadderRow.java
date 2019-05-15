package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderRow<T> {
    private List<Boolean> cols;

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

    public List<T> swapNames(final List<T> names) {
        if (cols.size() + 1 != names.size()) {
            throw new IllegalArgumentException(String.format("Name list's size(%d) is not match with ladder board row's number of columns", names.size()));
        }

        List<T> swappedList = new ArrayList<>(names);
        for (int i = 0; i < cols.size(); i++) {
            checkAndSwap(swappedList, i);
        }

        return swappedList;
    }

    private void checkAndSwap(List<T> list, int idx) {
        if (cols.get(idx)) {
            swapResult(list, idx, idx + 1);
        }
    }

    private void swapResult(List<T> list, int from, int to) {
        T tmp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, tmp);
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
