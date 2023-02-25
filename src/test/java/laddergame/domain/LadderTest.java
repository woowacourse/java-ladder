package laddergame.domain;

import laddergame.vo.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setup() {
        ladder = new Ladder(List.of(
                    new Line(List.of(Point.CONNECT, Point.DISCONNECT)),
                    new Line(List.of(Point.DISCONNECT, Point.CONNECT)),
                    new Line(List.of(Point.DISCONNECT, Point.CONNECT)),
                    new Line(List.of(Point.DISCONNECT, Point.CONNECT)),
                    new Line(List.of(Point.CONNECT, Point.DISCONNECT))
                ));
    }

    @Test
    @DisplayName("Ladder가 사람 수와 높이에 따라 정상적으로 생성된다.")
    void ladderCreateTest() {
        int expectedHeight = 5;
        assertThat(ladder.getLadder()).hasSize(expectedHeight);
    }

    @ParameterizedTest(name = "사다리 연결 테스트 [{index}]")
    @CsvSource(value = {"1,3", "2,2", "3,1"})
    void getArrivalLocationTest(int startPosition, int arrivalPosition) {
        assertThat(ladder.getArrivalPosition(new Position(startPosition))).isEqualTo(new Position(arrivalPosition));
    }
}
