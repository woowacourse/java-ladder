package laddergame.domain;

import laddergame.fixture.LineFixture;
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

class LinesTest {
    @DisplayName("라인 목록이 null이면 빈 리스트를 저장하여 예외가 발생한다.")
    @Test
    void throwExceptionWhenLinesIsNull() {
        final List<Line> lines = null;

        assertThatThrownBy(() -> new Lines(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 목록이 비어있으면 예외가 발생한다.")
    @Test
    void throwExceptionWhenLinesIsEmpty() {
        final List<Line> lines = List.of();

        assertThatThrownBy(() -> new Lines(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성한다.")
    @ParameterizedTest(name = "lines = {0}")
    @MethodSource("linesParameterDummy")
    void create(final List<Line> lines) {
        assertDoesNotThrow(() -> new Lines(lines));
    }

    @DisplayName("라인 목록을 가져올 수 있다.")
    @ParameterizedTest
    @MethodSource("linesParameterDummy")
    void getLines(final List<Line> inputLines) {
        final Lines lines = new Lines(inputLines);
        final List<Line> findLines = lines.getLines();

        assertThat(findLines).hasSize(inputLines.size());
    }

    @DisplayName("가로 세로 위치로 포인트를 가져온다.")
    @Test
    void getPointByColumnAndRow() {
        final List<Line> lineValues = List.of(
                new Line(List.of(true, false)),
                new Line(List.of(true, false)));
        final Lines lines = new Lines(lineValues);
        final Position column = new Position(0);
        final Position row = new Position(0);
        final boolean isPointTrue = lines.getPointByColumnAndRow(column, row);

        assertThat(isPointTrue).isTrue();
    }

    @DisplayName("라인의 세로 길이는 라인 사이즈와 동일하다.")
    @ParameterizedTest
    @MethodSource("linesParameterDummy")
    void getHeight(final List<Line> inputLines) {
        final Lines lines = new Lines(inputLines);
        final Height height = lines.getHeight();
        final int linesSize = inputLines.size();

        assertThat(height.getValue()).isEqualTo(linesSize);
    }

    static Stream<Arguments> linesParameterDummy() {
        return Stream.of(
                Arguments.arguments(List.of(LineFixture.createLine(2))),
                Arguments.arguments(List.of(LineFixture.createLine(3)))
        );
    }
}