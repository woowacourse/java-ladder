package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("Ladder가 사람 수와 높이에 따라 정상적으로 생성된다.")
    void ladderCreateTest() {
        int expectedHeight = 3;
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Point.CONNECT, Point.DISCONNECT)),
                new Line(List.of(Point.CONNECT, Point.DISCONNECT)),
                new Line(List.of(Point.CONNECT, Point.DISCONNECT))
        ));
        assertThat(ladder.getLadder()).hasSize(expectedHeight);
    }
}
