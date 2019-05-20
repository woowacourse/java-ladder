package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderStateTest {

    @Test
    void create() {
        LadderState state = new LadderState(3, new LadderHeight(3), new TestBooleanGenerator(Arrays.asList(true, false, false, true, true, false)));
        List<LadderState.LadderRow> rows = new ArrayList<>();
        state.forEachRows(rows::add);
        assertThat(rows.get(0).getDirections()).containsExactly(Direction.RIGHT, Direction.LEFT, Direction.DOWN);
        assertThat(rows.get(1).getDirections()).containsExactly(Direction.DOWN, Direction.RIGHT, Direction.LEFT);
        assertThat(rows.get(2).getDirections()).containsExactly(Direction.RIGHT, Direction.LEFT, Direction.DOWN);
    }

    @Test
    void createWithRandomGenerator() {
        // Direction.valueOf(true, true) 예외가 발생하는지 확인
        for (int i = 0; i < 1000; i++) {
            new LadderState(3, new LadderHeight(3), new RandomBooleanGenerator());
        }
    }
}
