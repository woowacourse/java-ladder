package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderStateTest {

    @Test
    public void testCreate() {
        LadderState state = new LadderState(2, 4,
            new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false)));
        assertThat(state.getBooleanMatrix())
            .containsExactly(Arrays.asList(true, false), Arrays.asList(true, false), Arrays.asList(false, true), Arrays.asList(false, false));
    }

    @Test
    void testCreateEmptyState() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderState(0, 0, new TestBooleanGenerator(Arrays.asList(true, false, false, true)));
        });
    }

    @Test
    void testCreateStateRandomly() {
        for (int i = 0; i < 100; i++) {
            testStateHasConsecutiveTrue();
        }
    }

    void testStateHasConsecutiveTrue() {
        List<List<Boolean>> mat =  new LadderState(3, 5, new RandomBooleanGenerator()).getBooleanMatrix();
        for (List<Boolean> row : mat) {
            testRowHasConsecutiveTrue(row);
        }
    }

    private void testRowHasConsecutiveTrue(List<Boolean> row) {
        for (int i = 0; i < row.size() - 1; i++) {
            throwIfRowHasConsecutiveTrue(row, i);
        }
    }

    private void throwIfRowHasConsecutiveTrue(List<Boolean> row, int idx) {
        if (row.get(idx) && row.get(idx + 1)) {
            throw new IllegalStateException("State has consecutive 'true's");
        }
    }
}
