package laddergame.domain;

import laddergame.fixture.PositionFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("라인")
class LineTest {
    @DisplayName("생성된다.")
    @ParameterizedTest(name = "lineValue = {0}")
    @MethodSource("lineParameterDummy")
    void create(final List<Boolean> lineValue) {
        assertDoesNotThrow(() -> new Line(lineValue));
    }

    @DisplayName("가로 라인이 겹치지 않으면 생성된다.")
    @Test
    void createWithBothFalse() {
        assertDoesNotThrow(() -> new Line(List.of(false, false, true)));
    }

    @DisplayName("포인트가 비어 있으면 예외가 발생한다.")
    @Test
    void throwExceptionWhenPointsIsEmpty() {
        assertThatThrownBy(() -> new Line(List.of()));
    }

    @DisplayName("포인트 하나를 위치로 조회한다.")
    @Test
    void getPointByPosition() {
        final Line line = new Line(List.of(true, false, true));
        final boolean isPointTrue = line.getPointByPosition(PositionFixture.createPositionZero());
        assertThat(isPointTrue).isTrue();
    }

    @DisplayName("가로 길이로 포인트 사이즈를 가져온다.")
    @ParameterizedTest(name = "lines = {0}")
    @MethodSource("lineParameterDummy")
    void getWidth(final List<Boolean> inputPoints) {
        final Line line = new Line(inputPoints);
        final Width width = line.getWidth();
        final int pointsSize = inputPoints.size();

        assertThat(width.getValue()).isEqualTo(pointsSize);
    }

    static Stream<Arguments> lineParameterDummy() {
        return Stream.of(
                Arguments.arguments(List.of(true, false)),
                Arguments.arguments(List.of(true, false, true)),
                Arguments.arguments(List.of(true, false, false)),
                Arguments.arguments(List.of(true, false, true, false)),
                Arguments.arguments(List.of(true, false, false, true)),
                Arguments.arguments(List.of(true, false, false, false))
        );
    }
}