package ladder.domain.resource.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.resource.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("전달된 이동 방향을 Line에 추가한다.")
    @Test
    void addDirection() {
        //given
        Line line = new Line();
        Direction direction = Direction.RIGHT;

        //when
        line.addDirection(direction);

        //then
        assertThat(line.getDirections()).containsExactly(direction);
    }

    @DisplayName("index값에 해당하는 방향을 반환한다.")
    @Test
    void getDirectionByIndex() {
        //given
        Line line = new Line();
        Direction direction = Direction.RIGHT;

        //when
        line.addDirection(direction);
        Direction directionByIndex = line.getDirectionByIndex(0);

        //then
        assertThat(directionByIndex).isEqualTo(direction);
    }

    @DisplayName("Line의 마지막 이동 방향을 반환한다.")
    @Test
    void getLastDirection() {
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

    @DisplayName("Line의 마지막 이동 방향 반환 요청 시, 빈 Line일 경우 예외를 발생시킨다.")
    @Test
    void getLastDirectionByEmptyLine() {
        //given
        Line line = new Line();

        //when, then
        assertThatThrownBy(line::getLastDirection)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 방향 정보가 없습니다.");
    }

    @DisplayName("Line의 크기를 반환한다.")
    @Test
    void getSize() {
        //given
        Line line = new Line();
        line.addDirection(Direction.RIGHT);

        //when
        int lineSize = line.getSize();

        //then
        assertThat(lineSize).isEqualTo(1);
    }

    @DisplayName("Line이 비어있는지 확인한다.")
    @Test
    void isEmpty() {
        //given
        Line line = new Line();

        //when
        boolean isEmpty = line.isEmpty();

        //then
        assertThat(isEmpty).isTrue();
    }
}
