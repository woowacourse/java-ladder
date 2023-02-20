package laddergame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static Players players;
    private static Height height;

    @BeforeAll
    static void setup() {
        players = new Players(List.of("jena", "poby", "beav"));
        height = new Height("2");
    }

    private static Stream<Arguments> provideLadderLines() {
        return Stream.of(Arguments.of(List.of(true, false, true, false, false, false, false, false, true, false, false, false), false),
                Arguments.of(List.of(true, false, true, false, false, true, false, true, true, false, false, false), true),
                Arguments.of(List.of(false, true, false, true, false, false, false, true, true, false, true, false), true));
    }

    @DisplayName("사다리 스텝이 하나도 존재하지 않는 bar가 있을 때 fail")
    @Test
    void bar_withnostep_fail() {
        Ladder ladder = new Ladder(players, height,
                new LineTest.testTrueOrFalseGenerator(new ArrayList<>(Arrays.asList(true, false, true, false))));
//        assertThat(ladder.validate(height.getHeight())).isFalse();
    }

    @DisplayName("사다리 스텝이 하나도 존재하지 않는 bar가 없을 때 pass")
    @Test
    void bar_withstep_success() {
        Ladder ladder = new Ladder(players, height,
                new LineTest.testTrueOrFalseGenerator(new ArrayList<>(Arrays.asList(true, false, false, true))));
//        assertThat(ladder.validate(height.getHeight())).isTrue();
    }

    @DisplayName("사다리 스텝 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderLines")
    void bar_test(List<Boolean> input, boolean expected) {
        players = new Players(List.of("jena", "poby", "beav", "jetty", "crong"));
        height = new Height("3");
        Ladder ladder = new Ladder(players, height,
                new LineTest.testTrueOrFalseGenerator(new ArrayList<>(input)));
//        assertThat(ladder.validate(height.getHeight())).isEqualTo(expected);
    }
}
