package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void testCreate() {
        Ladder ladder = new Ladder(Arrays.asList("pobi", "crong", "honux"), 4);
        assertThat(ladder.findDestination("pobi")).isEqualTo(0);
        assertThat(ladder.findDestination("crong")).isEqualTo(2);
        assertThat(ladder.findDestination("crong")).isEqualTo(1);

    }
}
