package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @DisplayName("라인의 포인트 개수는 19를 넘을 수 없다.")
    @Test
    void pointNotMoreThan19() {
        // given
        int pointSize = 20;
        List<Point> points = Stream.generate(() -> Point.NOT_EXIST)
                .limit(pointSize)
                .collect(Collectors.toList());

        // when, then
        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("포인트 범위는 0부터 19까지입니다.");
    }

    @DisplayName("라인의 포인트 개수는 0이상 19이하이다.")
    @ValueSource(ints = {0, 10, 19})
    @ParameterizedTest
    void pointSizeTest(int pointSize) {
        // given
        List<Point> points = Stream.generate(() -> Point.NOT_EXIST)
                .limit(pointSize)
                .collect(Collectors.toList());

        // when, then
        assertThatNoException()
                .isThrownBy(() -> new Line(points));
    }

    @DisplayName("사다리가의 포인트가 true인 지점이 연속되어 있을 경우 예외 처리 한다.")
    @ParameterizedTest
    @MethodSource("providePoints")
    void validatePointExistContinuous(List<Point> points) {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(points))
                .withMessageContaining("사다리는 같은 라인에서 연속되는 포인트를 가질 수 없습니다.");
    }

    @DisplayName("현재 위치가 주어지면 다음 라인에서 이동가능한 위치를 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4", "5:5"}, delimiter = ':')
    void getNextX(String providedCurrentX, String expectedX) {
        // given
        Line line = new Line(List.of(Point.EXIST, Point.NOT_EXIST, Point.EXIST, Point.NOT_EXIST, Point.NOT_EXIST));
        int currentX = Integer.parseInt(providedCurrentX);

        // when
        int nextX = line.getNextX(currentX);

        // then
        assertThat(nextX).isEqualTo(Integer.parseInt(expectedX));
    }

    private static Stream<Arguments> providePoints() {
        List<Point> pointsOfTwo = List.of(Point.EXIST, Point.EXIST);
        List<Point> pointsOfTen = Stream.generate(() -> Point.NOT_EXIST)
                .limit(8).collect(Collectors.toList());
        pointsOfTen.add(Point.EXIST);
        pointsOfTen.add(Point.EXIST);
        List<Point> pointsOfNineteen = Stream.generate(() -> Point.NOT_EXIST).limit(17).collect(Collectors.toList());
        pointsOfNineteen.add(Point.EXIST);
        pointsOfNineteen.add(Point.EXIST);
        return Stream.of(
                Arguments.of(pointsOfTwo),
                Arguments.of(pointsOfTen),
                Arguments.of(pointsOfNineteen)
        );
    }

}
