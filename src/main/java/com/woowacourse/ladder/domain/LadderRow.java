package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
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

    public List<String> swapNames(final List<String> names) {
        if (cols.size() + 1 != names.size()) {
            throw new IllegalArgumentException(String.format("Name list's size(%d) is not match with ladder board row's number of columns", names.size()));
        }

        List<String> swappedList = new ArrayList<>(names);
        for (int i = 0; i < cols.size(); i++) {
            checkAndSwap(swappedList, i);
        }

        return swappedList;
    }

    private void checkAndSwap(List<String> list, int idx) {
        if (cols.get(idx)) {
            swapResult(list, idx, idx + 1);
        }
    }

    private void swapResult(List<String> list, int from, int to) {
        String tmp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, tmp);
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
