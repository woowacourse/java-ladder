package domain.ladder;

import domain.Direction;
import domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {

    @Nested
    @DisplayName("랜덤 값의 의한 라인 생성 테스트(첫번째 좌표는 이전 좌표가 없는것을 표시)")
    class Creat {
        @DisplayName("들어간대로 잘 생성되었는지 테스트")
        @Test
        void createTest() {
            Line line = new Line((Arrays.asList(new Point(false), new Point(true), new Point(false))));

            assertThat(line.getPoints()).usingRecursiveComparison().isEqualTo(List.of(new Point(false), new Point(true), new Point(false)));
        }

        @DisplayName("이전 좌표와 현재 좌표가 겹칠때 변환 테스트")
        @Test
        void createLine2() {
            Line line = new Line((Arrays.asList(new Point(true), new Point(true), new Point(false))));
            assertThat(line.getPoints()).usingRecursiveComparison().isEqualTo(List.of(new Point(true), new Point(true), new Point(false)));
        }
    }

    @DisplayName("사다리의 따른 플레이어 이동")
    @Test
    void getDirection() {
        Player player = new Player("a", 0);
        Line line = new Line((Arrays.asList(new Point(true), new Point(false))));
        assertThat(line.getDirection(player)).isEqualTo(Direction.RIGHT);
    }
}