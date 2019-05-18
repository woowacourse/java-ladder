package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestinationTest {

    @Test
    void create() {
        assertThat(new Destination("1등")).isEqualTo(new Destination("1등"));
    }

    @Test
    void createWithSpacePrefixedString() {
        assertThat(new Destination(" 1등")).isEqualTo(new Destination("1등"));
    }

    @Test
    void createWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Destination("");
        });
    }

    @Test
    void createWithOverLengthString() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Destination("thesix");
        });
    }
}
