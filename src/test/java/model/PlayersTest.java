package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @Test
    @DisplayName("Players 객체 생성 성공 테스트")
    void createPlayersTest() {
        Names names = new Names("pobi, neo, hiiro");
        assertThatNoException().isThrownBy(()->{Players players = new Players(names);});
    }
}
