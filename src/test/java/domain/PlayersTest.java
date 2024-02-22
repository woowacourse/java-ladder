package domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @DisplayName("참가자 수가 2명 이상, 10명 이하이면 참가자 목록이 잘 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 10})
    void createPlayers(int playerCount) {
        //given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            names.add(String.valueOf(i));
        }
        //when
        final Players players = new Players(names);
        //then
        Assertions.assertThat(players.count()).isEqualTo(playerCount);
    }

    @DisplayName("참가자 수가 2명 미만, 10명 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    void invalidPlayersCount(int playerCount) {
        //given
        List<String> names = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            names.add(String.valueOf(i));
        }
        //when & then
        Assertions.assertThatThrownBy(() -> new Players(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자의 수를 반환한다.")
    @Test
    void getPlayersCount() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        //when
        final Players players = new Players(names);
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