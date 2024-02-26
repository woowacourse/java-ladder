package ladder.domain.resource.line;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.resource.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("전달된 이동 방향을 Line에 추가한다.")
    @Test
    void addDirectionTest() {
        //given
        Line line = new Line();
        Direction direction = Direction.RIGHT;

        //when
        line.addDirection(direction);

        //then
        assertThat(line.getDirectionsInfo()).containsExactly(direction);
    }

    @DisplayName("Line의 마지막 이동 방향을 반환한다.")
    @Test
    void getLastDirectionTest() {
        //given
        Line line = new Line();
        Direction firstDirection = Direction.RIGHT;
        Direction secondDirection = Direction.LEFT;

        line.addDirection(firstDirection);
        line.addDirection(secondDirection);

        //when
        Direction foundDirection = line.getLastDirection();

        //then
        assertThat(foundDirection).isEqualTo(secondDirection);
    }

    @DisplayName("Line의 크기를 반환한다.")
    @Test
    void getLineSizeTest() {
        //given
        Line line = new Line();
        line.addDirection(Direction.RIGHT);

        //when
        int lineSize = line.getLineSize();

        //then
        assertThat(lineSize).isEqualTo(1);
    }
}
