package domain;

import static domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class PointTest {
    @ParameterizedTest
    @MethodSource("ProvideArgumentsOfMoveByDirection")
    @DisplayName("인덱스가 주어졌을 때 방향에 맞게 움직인 인덱스를 반환한다")
    void moveByDirection(final Direction direction, final int expected) {
        final Point point = new Point(direction);
        final Index index = new Index(5);

        final Index actual = point.move(index);

        assertThat(actual).isEqualTo(new Index(expected));
    }

    public static Stream<Arguments> ProvideArgumentsOfMoveByDirection() {
        return Stream.of(
                Arguments.of(STRAIGHT, 5),
                Arguments.of(LEFT, 4),
                Arguments.of(RIGHT, 6)
        );
    }
}
