package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
