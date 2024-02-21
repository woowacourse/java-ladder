package domain;

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

    @DisplayName("참가자의 수를 반환한다.")
    @Test
    void getPlayersCount() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        //when
        final Players players = new Players(names);
        //when
        int playersCount = players.count();
        //then
        Assertions.assertThat(playersCount).isEqualTo(names.size());
    }

    @DisplayName("참가자들의 이름 목록을 반환한다.")
    @Test
    void getPlayerNames() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        final Players players = new Players(names);
        //when
        List<String> returnedNames = players.getNames();
        //then
        Assertions.assertThat(returnedNames).containsAll(names);
    }
}