package domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    Ladder ladder;
    @Test
    @BeforeEach
    void setUp() {
        ladder = new Ladder(List.of(new Line(List.of(new Point(false), new Point(true), new Point(false)))));
    }

    @Test
    @DisplayName("플레이어의 위치가 양쪽 사이드일때 위치 처리")
    void sideDecideWhereToGo() {
        assertThat(ladder.sideDecideWhereToGo(0, 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("플레이어의 위치가 양쪽 사이드가 아닐때 위치 처리")
    void decideWhereToGo() {
        assertThat(ladder.decideWhereToGo(1, 0)).isEqualTo(2);
    }
}