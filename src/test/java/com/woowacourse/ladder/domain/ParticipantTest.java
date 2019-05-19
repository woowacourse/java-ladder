package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantTest {

    @Test
    void create() {
        assertThat(new Participant("pobi")).isEqualTo(new Participant("pobi"));
    }

    @Test
    void createWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("");
        });
    }

    @Test
    void createWithSpacePrefixedName() {
        assertThat(new Participant(" pobi")).isEqualTo(new Participant("pobi"));
    }

    @Test
    void createWithPreservedName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("all");
        });
    }

    @Test
    void createdWithOverLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Participant("thesix");
        });
    }

    @Test
    void test() {
        assertThat("pobi, ,".split(",")[1].trim()).isEqualTo("");
    }
}
