package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderResultTest {
    @Test
    void testMatchResult() {
        LadderResult result = new LadderResult(Arrays.asList("pobi", "honux", "crong"), Arrays.asList("2등", "1등", "3등"));
        assertThat(result.matchParticipant("pobi").getDestination()).isEqualTo("2등");
        assertThat(result.matchParticipant("honux").getDestination()).isEqualTo("1등");
        assertThat(result.matchParticipant("crong").getDestination()).isEqualTo("3등");
    }

    @Test
    void testHasMatchResult() {
        LadderResult result = new LadderResult(Arrays.asList("pobi", "honux", "crong"), Arrays.asList("2등", "1등", "3등"));
        assertThat(result.hasMatchParticipant("pobi")).isTrue();
        assertThat(result.hasMatchParticipant("crong")).isTrue();
        assertThat(result.hasMatchParticipant("jk")).isFalse();
    }

    @Test
    void testMatchResultWithNonExistParticipant() {
        LadderResult result = new LadderResult(Arrays.asList("pobi", "honux", "crong"), Arrays.asList("2등", "1등", "3등"));
        assertThrows(IllegalArgumentException.class, () -> {
            result.matchParticipant("jk");
        });
    }
}
