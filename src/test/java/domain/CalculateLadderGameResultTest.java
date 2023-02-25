package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateLadderGameResultTest {

    private static final List<Link> LENGTH_THREE_LINE_CASE1 = List.of(Link.LINKED, Link.UNLINKED, Link.LINKED);
    private static final List<Link> LENGTH_THREE_LINE_CASE2 = List.of(Link.LINKED, Link.UNLINKED, Link.UNLINKED);
    private static final List<Link> LENGTH_THREE_LINE_CASE3 = List.of(Link.UNLINKED, Link.LINKED, Link.UNLINKED);
    private static final List<Link> LENGTH_THREE_LINE_CASE4 = List.of(Link.UNLINKED, Link.UNLINKED, Link.LINKED);
    private final CalculateLadderGameResult calculator = new CalculateLadderGameResult();
    private final List<String> prevUserNames = List.of("pobi", "honux", "crong", "jk");

    @ParameterizedTest
    @DisplayName("참여자들이 사다리의 한 라인을 통과 후 올바른 위치에 있는지 확인한다.")
    @MethodSource("lineAndUserPositionsDummy")
    void passLineTest(List<Line> testLine, List<String> postUserNames) {
        assertThat(calculator.passLadder(testLine, prevUserNames)).isEqualTo(postUserNames);
    }

    @Test
    @DisplayName("참여자들이 사다리를 통과 후 올바른 위치에 있는지 확인한다.")
    void passLadderTest() {
        List<Line> testLadder = List.of(new Line(LENGTH_THREE_LINE_CASE1), new Line(LENGTH_THREE_LINE_CASE2),
                new Line(LENGTH_THREE_LINE_CASE3), new Line(LENGTH_THREE_LINE_CASE4));
        List<String> postUserNames = List.of("pobi", "jk", "crong", "honux");

        assertThat(calculator.passLadder(testLadder, prevUserNames)).isEqualTo(postUserNames);

    }

    static Stream<Arguments> lineAndUserPositionsDummy() {
        return Stream.of(
                Arguments.arguments(List.of(new Line(LENGTH_THREE_LINE_CASE1)), List.of("honux", "pobi", "jk", "crong")),
                Arguments.arguments(List.of(new Line(LENGTH_THREE_LINE_CASE2)), List.of("honux", "pobi", "crong", "jk")),
                Arguments.arguments(List.of(new Line(LENGTH_THREE_LINE_CASE3)), List.of("pobi", "crong", "honux", "jk")),
                Arguments.arguments(List.of(new Line(LENGTH_THREE_LINE_CASE4)), List.of("pobi", "honux", "jk", "crong"))
        );
    }
}
