package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    @DisplayName("Players 객체 생성 성공 테스트")
    void createCarsTest() {
        Players players = new Players(Arrays.asList("pobi,crong,honux"));

        assertThat(players.getPlayers().size()).isEqualTo(3);
    }

}
