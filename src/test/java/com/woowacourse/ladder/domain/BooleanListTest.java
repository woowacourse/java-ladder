package com.woowacourse.ladder.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BooleanListTest {
    List<Boolean> bools;

    @BeforeEach
    void setUp() {
        bools = Arrays.asList(true, false, true, false);
    }

    @Test
    void Generate_BoolList_테스트() {
        List<Boolean> bools2 = Arrays.asList(true, false, true, false);
        assertThat(BooleanListGenerator.generateBoolList(5).size()).isEqualTo(bools2.size());
    }
}
