package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static Players players;
    private static Height height;

    @BeforeAll
    static void setup() {
        players = new Players(List.of("jena", "poby"));
        height = new Height("2");
    }

    @DisplayName("사다리 스텝이 하나도 존재하지 않는 bar가 있을 때 fail")
    @Test
    void bar_withnostep_fail() {
        Ladder ladder = new Ladder(players, height,
                new LineTest.testTrueOrFalseGenerator(new ArrayList<>(Arrays.asList(true, false, true, false))));
        assertThat(ladder.validate(height.getHeight())).isFalse();
    }

    @DisplayName("사다리 스텝이 하나도 존재하지 않는 bar가 없을 때 pass")
    @Test
    void bar_withstep_success() {
        Ladder ladder = new Ladder(players, height,
                new LineTest.testTrueOrFalseGenerator(new ArrayList<>(Arrays.asList(true, false, true, false, true, false))));
        assertThat(ladder.validate(height.getHeight())).isTrue();
    }
}
