package domain;

import static org.assertj.core.api.Assertions.*;

import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import domain.ladder.LadderGenerator;
import domain.player.Names;
import domain.player.Player;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.FixBooleanGenerator;

@DisplayName("사다리 게임은 ")
class LadderGameTest {
    private Players players;
    private Prizes prizes;
    private Ladder ladder;
    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        //given
        players = new Players(new Names(List.of("pobi", "crong", "bkcat")));
        prizes = new Prizes(List.of("3000", "4000", "5000"));
        ladder = new LadderGenerator(new FixBooleanGenerator(true, true, false,
                true, true, false)).build(2, 3);
        ladderGame = new LadderGame(ladder, players, prizes);
    }

    @Nested
    @DisplayName("생성 시")
    class GenerateTest {
        @Test
        @DisplayName("사다리, 플레이어 목록, 상품 목록을 받아 생성된다.")
        void generateLadderGameCase() {
            //then
            Assertions.assertDoesNotThrow(() -> new LadderGame(ladder, players, prizes));
        }
    }

    @Nested
    @DisplayName("플레이 시")
    class RideTest {
        @Test
        @DisplayName("모든 플레이어의 최종 위치로 업데이트한다.")
        void generateLadderGameCase() {
            //when
            ladderGame.play();

            //then
            checkPosition(players.getPlayers().get(0), 2);
            checkPosition(players.getPlayers().get(1), 0);
            checkPosition(players.getPlayers().get(2), 1);
        }

        void checkPosition(Player player, int targetPosition) {
            assertThat(player
                    .getPosition())
                    .isEqualTo(targetPosition);
        }
    }
}
