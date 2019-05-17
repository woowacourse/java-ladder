package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final LadderState state;

    public Ladder(LadderState ladderState) {
        this.state = ladderState;
    }

    public LadderResult explore(List<String> participants, List<String> destinations) {
        assertListSizeMatch(participants, destinations);
        List<String> participantsToSwap = new ArrayList<>(participants);
        List<List<Boolean>> matrix = state.getBooleanMatrix();
        for (int i = 0; i < matrix.size(); i++) {
            swapWithRow(participantsToSwap, matrix.get(i));
        }

        return new LadderResult(participantsToSwap, destinations);
    }

    private void swapWithRow(List<String> participantsToSwap, List<Boolean> row) {
        for (int j = 0; j < row.size(); j++) {
            checkAndSwap(participantsToSwap, row, j);
        }
    }

    private void checkAndSwap(List<String> participantsToSwap, List<Boolean> row, int j) {
        if(row.get(j)) {
            Collections.swap(participantsToSwap, j, j + 1);
        }
    }

    private void assertListSizeMatch(List<String> participants, List<String> destinations) {
        if (participants.size() != destinations.size() || participants.size() - 1 != state.getBooleanMatrix().get(0).size()) {
            throw new IllegalArgumentException(String.format("Sizes of participants and destinations are not equal: [%d, %d]", participants.size(), destinations.size()));
        }
    }
}
