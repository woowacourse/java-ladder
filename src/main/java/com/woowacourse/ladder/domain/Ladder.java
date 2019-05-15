package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder<T> {
    private LadderResult<T> result;
    private List<LadderRow<T>> rows;

    public Ladder(List<T> participants, int height, BooleanGenerator booleanGenerator) {
        rows = new ArrayList<>();

        // height 만큼의 Row 생성
        for (int i = 0; i < height; i++) {
            // 각 Row는 n(name) - 1 만큼의 Boolean 리스트를 가짐
            rows.add(new LadderRow<>(participants.size() - 1, booleanGenerator));
        }

        explore(participants);
    }

    private void explore(List<T> participants) {
        List<T> result = participants;
        for (LadderRow<T> row : rows) {
            result = row.swapNames(result);
        }
        this.result = new LadderResult<>(result);
    }

    public LadderResult<T> getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row : rows) {
            sb.append(row).append('\n');
        }
        return sb.toString();
    }
}
