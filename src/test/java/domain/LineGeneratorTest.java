package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineGeneratorTest {
    @ParameterizedTest
    @MethodSource("provideGenerator")
    @DisplayName("연결된 포인트는 연속으로 존재할 수 없다.")
    void testNoConsecutiveConnectedPoints(BooleanGenerator generator) {
        int personCount = 1000;
        LineGenerator lineGenerator = new LineGenerator(personCount, generator);
        Line line = new Line(lineGenerator.createPoints());
        List<Point> points = line.getPoints();
        int isInvalidLine = Collections.indexOfSubList(points, List.of(Point.CONNECTED, Point.CONNECTED));

        assertEquals(-1, isInvalidLine);
    }

    static Stream<Arguments> provideGenerator() {
        return Stream.of(
                Arguments.of(new FixedBooleanGenerator(true)),
                Arguments.of(new FixedBooleanGenerator(false)),
                Arguments.of(new RandomBooleanGenerator())
        );
    }
}
