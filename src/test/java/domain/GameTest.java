package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("생성 테스트")
    @Test
    void creatGame() {
        Assertions.assertThatCode(() -> new Game("아톰,산초"))
                .doesNotThrowAnyException();
    }

    @DisplayName("게임에 사람들이 참여한다.")
    @Test
    void playersParticipate() {
        Game game = new Game("아톰, 산초");
        Assertions.assertThat(game.getPlayers())
                .containsExactly(new Player("아톰"), new Player("산초"));
    }
}
