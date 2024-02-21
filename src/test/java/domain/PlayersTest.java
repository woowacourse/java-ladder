package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("이름들로 참가자 목록을 생성한다.")
    @Test
    void createPlayers() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        //when
        final Players players = new Players(names);
        //then
        Assertions.assertThat(players.getPlayers()).hasSize(4);
    }
}