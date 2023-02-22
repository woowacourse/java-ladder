package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    private Line line;

    @BeforeEach
    void init() {
        this.line = new Line(3);
    }

    @DisplayName("이전 가로가 True면 다음 가로는 무조건 False이다.")
    @Test
    void 사다리_순서를_계산한다() {
        IntStream.range(0, line.getPoints().size() - 1)
                .filter(i -> line.getPoints().get(i) == true)
                .forEach(i -> Assertions.assertThat(line.getPoints().get(i + 1))
                        .isFalse());
    }

    @DisplayName("현재 플레이어가 갈 수 있는 사다리인지 판단한다.")
    @Test
    void isRightLadder() {
        // given
        Players players = new Players(List.of("베베", "카일", "우가", "리오", "디노"));
        List<Boolean> points = List.of(true, false, true, false);

        // when, then
        assertAll(() -> {
            assertEquals(new Line(5).isRightLadder(0, points), "right");
            assertEquals(new Line(5).isRightLadder(1, points), "left");
            assertEquals(new Line(5).isRightLadder(2, points), "right");
            assertEquals(new Line(5).isRightLadder(3, points), "left");
            assertEquals(new Line(5).isRightLadder(4, points), null);
        });
    }
}
