package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void testCreate() {
        LadderResult result = new Ladder(3, 4,
            new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false)))
            .explore(Arrays.asList("pobi", "crong", "honux"),
                Arrays.asList("0", "1", "2"));
        assertThat(result.matchResult("pobi")).isEqualTo(new MatchPair("pobi", "0"));
        assertThat(result.matchResult("crong")).isEqualTo(new MatchPair("crong", "2"));
        assertThat(result.matchResult("honux")).isEqualTo(new MatchPair("honux", "1"));
    }

}
