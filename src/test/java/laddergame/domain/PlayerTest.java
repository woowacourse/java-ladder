package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("플레이어")
public class PlayerTest {
    @Test
    @DisplayName("플레이어 이름이 제대로 생성되었는지 테스트한다.")
    public void nameCreateTest() {
        //given
        final String actualName = "name";

        //when
        final Player player = new Player(actualName, new Position(0,0));
        final String expectName = player.getName();

        //then
        assertEquals(actualName, expectName);
    }

    @Test
    @DisplayName("플레이어 이름이 5자 초과일 경우 예외가 발생한다.")
    public void nameExceedMaxLengthException() {
        //given
        final String actualName = "nameTest";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(actualName, new Position(0,0));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("플레이어 이름이 공백일 경우 예외가 발생한다.")
    public void nameBlankException(final String name) {
        //given & when & then
        assertThrows(IllegalArgumentException.class, () -> new Player(name, new Position(0,0)));
    }

    @Test
    @DisplayName("방향이 오른쪽이면 플레이어의 위치가 오른쪽으로 이동한다.")
    void moveRightWhenDirectionRight() {
        final Position position = new Position(0, 0);
        final Player player = new Player("name1", position);
        final Position expectedPosition = new Position(1, 1);

        player.moveLine(Direction.RIGHT);

        assertTrue(expectedPosition.equals(player.getPosition()));
    }
}
