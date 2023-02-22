package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateLadderGameResultTest {
    final CalculateLadderGameResult calculator = new CalculateLadderGameResult();

    @ParameterizedTest
    @DisplayName("참여자가 사다리의 한 라인을 통과 후 올바른 위치에 있는지 확인한다.")
    @MethodSource("lineAndUserPositionsDummy")
    void PassLineTest(List<Line> testLine, List<String> postUserNames) {
        List<String> prevUserNames = List.of("pobi", "honux", "crong", "jk");

        assertThat(calculator.passLadder(testLine, prevUserNames)).isEqualTo(postUserNames);
    }

    static Stream<Arguments> lineAndUserPositionsDummy() {
        return Stream.of(
                Arguments.arguments(List.of(new Line(List.of(Link.LINKED, Link.UNLINKED, Link.LINKED))),
                        List.of("honux", "pobi", "jk", "crong")),
                Arguments.arguments(List.of(new Line(List.of(Link.LINKED, Link.UNLINKED, Link.UNLINKED))),
                        List.of("honux", "pobi", "crong", "jk")),
                Arguments.arguments(List.of(new Line(List.of(Link.UNLINKED, Link.LINKED, Link.UNLINKED))),
                        List.of("pobi", "crong", "honux", "jk")),
                Arguments.arguments(List.of(new Line(List.of(Link.UNLINKED, Link.UNLINKED, Link.LINKED))),
                        List.of("pobi", "honux", "jk", "crong"))
        );
    }
}
