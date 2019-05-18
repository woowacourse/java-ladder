package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderHeightTest {

    @Test
    void create() {
        assertThat(new LadderHeight(5)).isEqualTo(new LadderHeight(5));
    }

    @Test
    void createWithInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LadderHeight(0);
        });
    }
}
