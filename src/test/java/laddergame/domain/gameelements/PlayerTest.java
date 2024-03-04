package laddergame.domain.gameelements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {
    // TODO assertThat과 assertEquals 혼용x /
    // TODO assertAll로 감싸기
    // TODO equals가 재정의되어 있지 않음
    @DisplayName("플레이어는 위치를 좌우로 움직일 수 있다")
    @Test
    void playerMovingTest() {
        Player testPlayer1 = new Player(new Name("a"), new Position(1));
        Player testPlayer2 = new Player(new Name("b"), new Position(1));

        Position expectedPosition1 = new Position(0);
        Position expectedPosition2 = new Position(2);

        testPlayer1.moveLeft();
        testPlayer2.moveRight();
        assertAll(
                () -> assertTrue(testPlayer1.getPlayerPosition().isSame(expectedPosition1)),
                () -> assertTrue(testPlayer2.getPlayerPosition().isSame(expectedPosition2))
        );
    }

    @DisplayName("플레이어 이름은 예약어 all이 될 수 없다")
    @Test
    void playerReservedNameTest() {
        Name reservedName = new Name("all");
        Position position = new Position(1);

        assertThatThrownBy(() -> new Player(reservedName, position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("예약어 all은 이름으로 지정할 수 없습니다.");
    }

}
