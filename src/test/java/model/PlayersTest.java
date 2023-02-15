package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    @DisplayName("Players 객체 생성 성공 테스트")
    void createCarsTest() {
        Players players = new Players("pobi,crong,honux");

        assertThat(players.getPlayers().size()).isEqualTo(3);
    }

}
