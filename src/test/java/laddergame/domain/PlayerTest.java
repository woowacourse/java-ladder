package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("플레이어")
public class PlayerTest {
    @Test
    @DisplayName("플레이어 이름이 제대로 생성되었는지 테스트한다.")
    void nameCreateTest() {
        //given
        final String actualName = "name";

        //when
        final Player player = new Player(actualName);
        final String expectName = player.getName();

        //then
        assertEquals(actualName, expectName);
    }

    @Test
    @DisplayName("플레이어 이름이 5자 초과일 경우 예외가 발생한다.")
    public void nameExceedMaxLengthException() {
        //given
        final String actualName = "nameTest";

        //when&then
        assertThrows(IllegalArgumentException.class, () -> {new Player(actualName);});
    }
}
