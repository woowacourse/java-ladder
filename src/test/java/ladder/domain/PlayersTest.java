package ladder.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("플레이어 들이 생성된다")
    void setPlayers() {
        List<PlayerName> playerNames = List.of(new PlayerName("hogee"), new PlayerName("jazz"));
        Assertions.assertThatCode(() -> new Players(playerNames))
                .doesNotThrowAnyException();
    }

    
}
