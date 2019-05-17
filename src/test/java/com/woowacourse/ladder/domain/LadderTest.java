package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    @Test
    void testExplore() {
        Ladder ladder = new Ladder(
            new LadderState(2, 4, new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false)))
        );

        LadderResult result = ladder.explore(Arrays.asList("pobi", "crong", "honux"), Arrays.asList("1등", "2등", "3등"));
        assertThat(result.matchParticipant("pobi").getDestination()).isEqualTo("1등");
        assertThat(result.matchParticipant("crong").getDestination()).isEqualTo("3등");
        assertThat(result.matchParticipant("honux").getDestination()).isEqualTo("2등");
    }

    @Test
    void testExploreWithNotMatchParticipantAndDestination() {
        Ladder ladder = new Ladder(
            new LadderState(2, 4, new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false)))
        );
        assertThrows(IllegalArgumentException.class, () -> {
            ladder.explore(Arrays.asList("pobi", "crong"), Arrays.asList("1등", "2등", "3등"));
        });
    }

    @Test
    void testExploreWithNotMatchWidth() {
        Ladder ladder = new Ladder(
            new LadderState(3, 4,
                new TestBooleanGenerator(Arrays.asList(true, false, true, false, false, true, false, false, true, false, false, true)))
        );

        assertThrows(IllegalArgumentException.class, () -> {
            ladder.explore(Arrays.asList("pobi", "crong", "honux"), Arrays.asList("1등", "2등", "3등"));
        });
    }
}
