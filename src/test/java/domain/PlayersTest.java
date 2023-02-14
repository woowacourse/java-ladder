package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

    @Test
    @DisplayName("중복된 이름을 가진 참가자가 없을 경우 Players 객체가 생성된다.")
    void createPlayers_Success() {
        List<Player> players = List.of(new Player("gray"), new Player("encho"), new Player("pobi"));
        assertThatNoException().isThrownBy(() -> new Players(players));
    }

    @Test
    @DisplayName("중복된 이름을 가진 참가자가 있을 경우 예외가 발생한다.")
    void createPlayers_Fail() {
        List<Player> players = List.of(new Player("gray"), new Player("encho"), new Player("gray"));
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
