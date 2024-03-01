package domain;

import static domain.Direction.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.generator.RandomGenerator;
import domain.mock.ConnectNextPointGenerator;
import domain.mock.EmptyGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {
    @Test
    @DisplayName("첫번째 지점에서 왼쪽으로 연결 됐을 때 예외가 발생한다")
    void firstPoint() {
        assertThatCode(() -> Line.ofDirections(LEFT)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 지점에서 오른쪽으로 연결 됐을 때 예외가 발생한다")
    void lastPoint() {
        assertThatCode(() -> Line.ofDirections(RIGHT)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,2", "2,1"})
    @DisplayName("선택된 점은 연결된 가로선에 따라 움직인다")
    void move(final int startPosition, final int expected) {
        final Index startIndex = new Index(startPosition);
        final Index expectedIndex = new Index(expected);
        final Line line = Line.ofDirections(STRAIGHT, RIGHT, LEFT);

        final Index actual = line.move(startIndex);

        assertThat(actual).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("두 세로선에서 한쪽만 연결되어 있으면 예외가 발생한다")
    void oneConnection() {
        assertAll(
                () -> assertThatCode(() -> Line.ofDirections(RIGHT, STRAIGHT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatCode(() -> Line.ofDirections(STRAIGHT, LEFT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatCode(() -> Line.ofDirections(STRAIGHT, LEFT, RIGHT, STRAIGHT))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("ProvideArgumentsOfGenerateLine")
    @DisplayName("길이와 생성기가 주어졌을 때 그에 맞는 라인을 생성한다")
    void generateLine(final RandomGenerator generator, final Line expected) {
        final Line actual = Line.generate(expected.size(), generator);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> ProvideArgumentsOfGenerateLine() {
        return Stream.of(
                Arguments.of(new EmptyGenerator(),
                        Line.ofDirections(STRAIGHT, STRAIGHT, STRAIGHT, STRAIGHT, STRAIGHT, STRAIGHT)),
                Arguments.of(new ConnectNextPointGenerator(),
                        Line.ofDirections(RIGHT, LEFT, RIGHT, LEFT, RIGHT, LEFT))
        );
    }

}
