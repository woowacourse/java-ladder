package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    List<Boolean> bools;

    @BeforeEach
    void setUp() {
        bools = Arrays.asList(true, false, true, false);
    }

    @Test
    void create_Points메소드_테스트() {
        Ladder ladder = new Ladder();
        assertThat(ladder.createPoints(bools).size()).isEqualTo(5);
    }

    @Test
    void create_Directions메소드_테스트() {
        Ladder ladder = new Ladder();
        assertThat(ladder.createDirections(bools).size()).isEqualTo(5);
    }
}
