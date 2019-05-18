package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static Position match(Position startPosition, LadderState state) {
        List<LadderState.LadderRow> rows = new ArrayList<>();
        Position currentPosition = startPosition;
        state.forEachRows(rows::add);
        for (LadderState.LadderRow row : rows) {
            currentPosition = currentPosition.moveMatch(row.getDirections());
        }

        return currentPosition;
    }
}
