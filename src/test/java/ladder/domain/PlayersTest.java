package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("이름 리스트를 받아 Player와 StartPoint 쌍을 생성한다.")
    void players_generatePairFromNames() {
        // expected
        List<String> names = List.of("dochi", "vero", "tori", "adfa");
        Players players = new Players(names);
        for(int i = 0; i < names.size(); i++) {
            assertThat(players.getPlayerName(new StartPoint(i)))
                    .isEqualTo(names.get(i));

        }
    }
}
