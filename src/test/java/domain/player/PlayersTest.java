package domain.player;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("플레이어 객체는")
class PlayersTest {

    @Test
    @DisplayName(" 이름을 받아서 정상 생성된다.")
    void createPlayersCase() {
        //given
        Names names = new Names(List.of("pobi", "crong", "bkcat"));

        //then
        assertDoesNotThrow(() -> new Players(names));
    }
}
