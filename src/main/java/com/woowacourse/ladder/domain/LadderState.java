package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.interfaces.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderState {
    private static final int MIN = 1;

    private List<List<Boolean>> matrix;

    public LadderState(int width, int height, BooleanGenerator booleanGenerator) {
        assertWidthAndHeight(width, height);
        matrix = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            matrix.add(createRow(width, booleanGenerator));
        }
    }

    private void assertWidthAndHeight(int width, int height) {
        if (width < MIN || height < MIN) {
            throw new IllegalArgumentException(String.format("Invalid width/height: %d/%d", width, height));
        }
    }

    private List<Boolean> createRow(int width, BooleanGenerator booleanGenerator) {
        List<Boolean> row = new ArrayList<>();
        boolean previousState = booleanGenerator.generateBoolean();
        row.add(previousState);
        for(int j = 1; j < width; j++) {
            boolean generated = booleanGenerator.generateBoolean();
            row.add(decideCurrentState(previousState, generated));
            previousState = generated;
        }
        return row;
    }

    private boolean decideCurrentState(boolean previousState, boolean currentState) {
        if (previousState) {
            return false;
        }
        return currentState;
    }

    public List<List<Boolean>> getBooleanMatrix() {
        List<List<Boolean>> matrix = new ArrayList<>();
        for (List<Boolean> row : this.matrix) {
            matrix.add(new ArrayList<>(row));
        }
        return matrix;
    }
}
