package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void testCreate() {
        LadderResult<String> result = new Ladder<>(Arrays.asList("pobi", "crong", "honux"), 4,
            new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false))).getResult();
        assertThat(result.indexOf("pobi")).isEqualTo(0);
        assertThat(result.indexOf("crong")).isEqualTo(2);
        assertThat(result.indexOf("honux")).isEqualTo(1);
    }

}
