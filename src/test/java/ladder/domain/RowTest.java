package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RowTest {
    @Test
    @DisplayName("발판이 가로로 연속적이면 예외가 발생한다")
    public void 생성_fail_연속발판() {
        assertThatThrownBy(() -> Row.of(List.of(Foothold.PASSABLE, Foothold.PASSABLE), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로로 연속된 발판은 만들 수 없습니다.");
    }

    @Test
    @DisplayName("width가 player수 - 1이 아니면 예외가 발생한다")
    public void 생성_fail_width사이즈() {
        assertThatThrownBy(() -> Row.of(List.of(Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE), 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 너비가 맞지 않습니다.");
    }

    @ParameterizedTest(name = "발판이 가로로 {0}, {1}이면 정상 생성된다")
    @CsvSource({"PASSABLE,BLOCKED", "BLOCKED,BLOCKED"})
    public void 생성_success(Foothold first, Foothold second) {
        assertThatNoException()
                .isThrownBy(() -> Row.of(List.of(first, second), 2));
    }

    @ParameterizedTest(name = "player가 move하면 사다리를 1칸 내려간다")
    @CsvSource({"0,1", "1,0", "2,2", "3,4", "4,3"})
    void 높이_1칸_이동(int beforeMove, int after) {
        List<Foothold> footholds = List.of(Foothold.PASSABLE, Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE);
        int expectedWidth = 4;
        Row row = Row.of(footholds, expectedWidth);
        PlayerPosition playerPosition = new PlayerPosition(beforeMove);

        assertThat(row.movePlayer(playerPosition)).isEqualTo(new PlayerPosition(after));
    }
}
