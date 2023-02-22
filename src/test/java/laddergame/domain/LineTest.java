package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LineTest {

    @Test
    @DisplayName("Line이 정상적으로 생성된다.")
    void lineCreateTest() {
        Line line = new Line(List.of(Point.CONNECT, Point.DISCONNECT, Point.CONNECT));
        int expectedPointCount = 3;
        assertThat(line.getLine()).hasSize(expectedPointCount);
    }

    @Test
    @DisplayName("이웃한 라인끼리는 겹치지 않는다.")
    void overlapNeighborLineTest() {
        List<Point> inputPoints = List.of(Point.CONNECT, Point.CONNECT, Point.CONNECT);
        List<Point> expectedPoints = List.of(Point.CONNECT, Point.DISCONNECT, Point.CONNECT);
        Line line = new Line(inputPoints);
        assertThat(line.getLine().equals(expectedPoints)).isTrue();
    }

    @ParameterizedTest(name = "\"| |-| |-|\"에서 연결된 점 찾기 테스트 : {0} - {1}")
    @CsvSource(value = {"1,1", "2,3", "3,2", "4,5", "5,4"})
    void getConnectedPosition(int startPosition, int arrivalPosition) {
        Line line = new Line(List.of(Point.DISCONNECT, Point.CONNECT, Point.DISCONNECT, Point.CONNECT));
        assertThat(line.getConnectedPosition(new Position(startPosition))).isEqualTo(new Position(arrivalPosition));
    }
}
