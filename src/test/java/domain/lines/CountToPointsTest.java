package domain.lines;

import domain.BooleanGenerator;
import domain.RandomBooleanGenerator;
import domain.line.Line;
import domain.line.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountToPointsTest {
    @ParameterizedTest
    @MethodSource("provideGenerator")
    @DisplayName("연결된 포인트는 연속으로 존재할 수 없다.")
    void testNoConsecutiveConnectedPoints(BooleanGenerator generator) {
        int personCount = 1000;
        CountToPoints countToPoints = new CountToPoints(personCount, generator);
        Line line = new Line(countToPoints.value());
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
