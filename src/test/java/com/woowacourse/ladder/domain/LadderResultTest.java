package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    void testMatchResult() {
        LadderResult<String, String> ladderResult = new LadderResult<>(new ParticipantGroup<>(Arrays.asList("pobi","crong","jk")), new DestinationGroup<>(Arrays.asList("꽝","5000","꽝")));
        assertThat(ladderResult.matchResult("pobi")).isEqualTo(new MatchPair<>("pobi", "꽝"));
        assertThat(ladderResult.matchResult("crong")).isEqualTo(new MatchPair<>("crong", "5000"));
        assertThat(ladderResult.matchResult("jk")).isEqualTo(new MatchPair<>("jk", "꽝"));
    }
}
