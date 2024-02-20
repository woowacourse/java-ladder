package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("플레이어")
public class PlayerTest {
    @Test
    @DisplayName("플레이어 이름이 제대로 생성되었는지 테스트한다.")
    void playerNameCreateTest() {
        //given
        String actualName = "name";

        //when
        Player player = new Player(actualName);
        String expectName = player.getName();

        //then
        assertEquals(actualName, expectName);
    }
}
