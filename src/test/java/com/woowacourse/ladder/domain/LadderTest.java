package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void testCreate() {
        Ladder ladder = new Ladder(Arrays.asList("pobi", "crong", "honux"), 4,
            new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false)));
        assertThat(ladder.findDestination("pobi")).isEqualTo(0);
        assertThat(ladder.findDestination("crong")).isEqualTo(2);
        assertThat(ladder.findDestination("honux")).isEqualTo(1);

    }
}
