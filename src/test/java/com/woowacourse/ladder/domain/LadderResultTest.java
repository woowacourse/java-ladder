package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    void testMatchResult() {
        List<String> result = Arrays.asList("꽝","5000","꽝");
        LadderResult<String> ladderResult = new LadderResult<>(Arrays.asList("pobi","crong","jk"));
        assertThat(ladderResult.matchResult(result,"pobi")).isEqualTo("꽝");
        assertThat(ladderResult.matchResult(result,"crong")).isEqualTo("5000");
        assertThat(ladderResult.matchResult(result,"jk")).isEqualTo("꽝");
    }
}
