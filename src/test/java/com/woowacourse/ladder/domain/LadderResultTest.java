package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    void testMatchResult() {
        LadderResult<String, String> ladderResult = new LadderResult<>(Arrays.asList("pobi","crong","jk"), Arrays.asList("꽝","5000","꽝"));
        assertThat(ladderResult.matchResult("pobi")).isEqualTo("꽝");
        assertThat(ladderResult.matchResult("crong")).isEqualTo("5000");
        assertThat(ladderResult.matchResult("jk")).isEqualTo("꽝");
    }
}
