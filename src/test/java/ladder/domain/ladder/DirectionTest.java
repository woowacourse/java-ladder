package ladder.domain.ladder;

import ladder.domain.MockRandomBooleanGenerator;
import ladder.domain.laddergame.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    MockRandomBooleanGenerator mockRandomBooleanGenerator = new MockRandomBooleanGenerator();

    @Test
    @DisplayName("양쪽이 연결된 Direction을 생성하려고 하면 예외가 발생한다")
    void from() {
        final boolean left = true;
        final boolean right = true;

        assertThatThrownBy(() -> Direction.from(left, right))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양쪽이 연결되어 있습니다.");
    }

    @Test
    @DisplayName("현재 Direction이 LEFT인 경우, STAY 혹은 RIGHT가 생성된다")
    void nextDirectionOfLEFT_Test() {
        final Direction currentDirection = Direction.LEFT;
        final Direction nextDirection = currentDirection.next(mockRandomBooleanGenerator);

        assertThat(nextDirection == Direction.STAY || nextDirection == Direction.RIGHT)
                .isTrue();
    }

    @Test
    @DisplayName("현재 Direction이 RIGHT인 경우, LEFT가 생성된다")
    void nextDirectionOfRIGHT_Test() {
        final Direction currentDirection = Direction.RIGHT;
        final Direction nextDirection = currentDirection.next(mockRandomBooleanGenerator);

        assertThat(nextDirection)
                .isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("현재 Direction이 STAY인 경우, STAY 혹은 RIGHT가 생성된다")
    void nextDirectionOfSTAY_Test() {
        final Direction currentDirection = Direction.STAY;
        final Direction nextDirection = currentDirection.next(mockRandomBooleanGenerator);

        assertThat(nextDirection == Direction.STAY || nextDirection == Direction.RIGHT)
                .isTrue();
    }

    @Test
    @DisplayName("이전 Direction이 RIGHT인 경우, 마지막 Direction은 LEFT이다 ")
    void last_is_LEFT_After_RIGHT() {
        final Direction currentDirection = Direction.RIGHT;
        final Direction lastDirection = currentDirection.last();

        assertThat(lastDirection).isEqualTo(Direction.LEFT);
    }


    @ParameterizedTest
    @EnumSource(value = Direction.class, names = {"STAY", "LEFT"})
    @DisplayName("이전 Direction이 LEFT 혹은 STAY인 경우, 마지막 Direction은 STAY이다 ")
    void last_is_STAY_After_LEFT_Or_STAY(final Direction currentDirection) {
        final Direction lastDirection = currentDirection.last();

        assertThat(lastDirection).isEqualTo(Direction.STAY);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "10,9"})
    @DisplayName("현재 Direction이 LEFT인 경우, 다음 Position은 현재 Position-1 이다.")
    void moveLeft(final int currentIndex, final int movedIndex) {
        final Position curretPosition = new Position(currentIndex);
        final Direction currentDirection = Direction.LEFT;

        assertThat(currentDirection.move(curretPosition))
                .isEqualTo(new Position(movedIndex));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "8,9"})
    @DisplayName("현재 Direction이 RIGHT인 경우, 다음 Position은 현재 Position+1 이다.")
    void moveRight(final int currentIndex, final int movedIndex) {
        final Position curretPosition = new Position(currentIndex);
        final Direction currentDirection = Direction.RIGHT;

        assertThat(currentDirection.move(curretPosition))
                .isEqualTo(new Position(movedIndex));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("현재 Direction이 STAY인 경우, 다음 Position은 현재 Position과 같다.")
    void moveStay(final int currentIndex) {
        final Position curretPosition = new Position(currentIndex);
        final Direction currentDirection = Direction.STAY;

        assertThat(currentDirection.move(curretPosition))
                .isEqualTo(new Position(currentIndex));

    }

    @Test
    @DisplayName("현재 Position이 0인 경우 왼쪽으로 갈 수 없다.")
    void UnableToMoveLeftWhenPositionIsZero() {
        final Position curretPosition = new Position(0);
        final Direction currentDirection = Direction.LEFT;

        assertThatThrownBy(() -> currentDirection.move(curretPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 작은 숫자로 이동할 수 없습니다");
    }

}
