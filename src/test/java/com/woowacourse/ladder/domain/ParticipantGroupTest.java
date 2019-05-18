package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantGroupTest {

    @Test
    void create() {
        assertThat(new ParticipantGroup("pobi, crong, jk"))
        .isEqualTo(new ParticipantGroup("pobi,crong,jk"));
    }

    @Test
    void createEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ParticipantGroup(",,");
        });
    }

    @Test
    void contains() {
        ParticipantGroup pg = new ParticipantGroup("pobi, crong, jk, honux");
        assertThat(pg.contains(new ParticipantGroup("pobi, honux"))).isTrue();
        assertThat(pg.contains(new ParticipantGroup("jk, other"))).isFalse();
    }

    @Test
    void positionOf() {
        ParticipantGroup pg = new ParticipantGroup("pobi, crong, jk, honux");
        assertThat(pg.positionOf(new Participant("crong"))).isEqualTo(1);
        assertThat(pg.positionOf(new Participant("honux"))).isEqualTo(3);
    }
}
