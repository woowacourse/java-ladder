package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("플레이어들")
public class PlayersTest {
    @Test
    @DisplayName("플레이어 이름에 중복이 있을 경우 예외가 발생한다.")
    public void nameDuplicateException() {
        //given
        final String name = "name";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Players.from(List.of(name, name)));

    }
}
