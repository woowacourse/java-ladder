package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import domain.line.Line;
import domain.line.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LineTest {
    @ParameterizedTest
    @MethodSource("provideGenerator")
    @DisplayName("가로 라인은 겹치지 않아야 한다.")
    void isLineCannotNextToLine(BooleanGenerator generator) {
        int personCount = 1000;
        Line line = new Line(personCount, generator);
        List<Point> points = line.getPoints();
        int isInvalidLine = Collections.indexOfSubList(points, List.of(Point.CONNECTED, Point.CONNECTED));

        assertEquals(-1, isInvalidLine);
    }

    Stream<Arguments> provideGenerator() {
        return Stream.of(
                Arguments.of(new FixedBooleanGenerator(true)),
                Arguments.of(new FixedBooleanGenerator(false)),
                Arguments.of(new RandomBooleanGenerator())
        );
    }
}

class FixedBooleanGenerator implements BooleanGenerator {
    private final boolean value;

    public FixedBooleanGenerator(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean generate() {
        return value;
    }
}
