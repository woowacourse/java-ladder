package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void match() {
        LadderState state = new LadderState(3, new LadderHeight(3), new TestBooleanGenerator(Arrays.asList(true, false, false, true, true, false)));
        assertThat(Ladder.match(new Position(0, 3), state)).isEqualTo(new Position(2, 3));
        assertThat(Ladder.match(new Position(1, 3), state)).isEqualTo(new Position(1, 3));
        assertThat(Ladder.match(new Position(2, 3), state)).isEqualTo(new Position(0, 3));
    }
}
