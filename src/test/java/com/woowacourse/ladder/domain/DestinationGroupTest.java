package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestinationGroupTest {

    @Test
    void create() {
        assertThat(new DestinationGroup("1등, 2등, 3등"))
            .isEqualTo(new DestinationGroup("1등,2등, 3등"));
    }

    @Test
    void createEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DestinationGroup(",,");
        });
    }
}
