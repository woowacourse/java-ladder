package laddergame.domain;

import laddergame.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LadderTest {
    private static Players players;
    private static Height height;

    private static Stream<Arguments> provideLadderLines() {
        return Stream.of(Arguments.of(List.of(true, false, true, false, false, true, false, true, true, false, false, false), true),
                Arguments.of(List.of(false, true, false, true, false, false, false, true, true, false, true, false), true));
    }


    @DisplayName("사다리 스텝 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderLines")
    void bar_test_success(List<Boolean> input, boolean expected) {
        players = new Players(List.of("jena", "poby", "beav", "jetty", "crong"));
        height = new Height(3);
        Ladder ladder = new Ladder(players, height,
                new TestTrueOrFalseGenerator(new ArrayList<>(input)));
        Validator validator = new Validator();
        assertThatNoException().isThrownBy(() -> validator.validateLadder(ladder, height.getHeight()));
    }
}
