package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergame.domain.ladder.LadderFixture.ladder;
import static laddergame.domain.ladder.LadderFixture.players;
import static laddergame.domain.ladder.LadderFixture.prizes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderGameTest {

    private LadderFixture fixture;
    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        fixture = new LadderFixture();
        ladderGame = LadderGame.of(ladder, players, prizes);
    }

    @Test
    @DisplayName("사다리와 플레이어들로 사다리 게임을 만들 수 있다.")
    void givenPlayerAndLadder_whenCreateLadder_thenSuccess() {
        // then
        assertAll(
                () -> assertThat(ladderGame)
                        .extracting("ladder")
                        .isEqualTo(ladder),
                () -> assertThat(ladderGame)
                        .extracting("players")
                        .isEqualTo(players)
        );
    }

    @Test
    @DisplayName("사다리게임을 시작하면 플레이어가 왼쪽으로 움직일 수 있으면 왼쪽으로 움직인다.")
    void givenLadder_whenStartGame_thenReturnLeftMoveResult() {
        // when
        ladderGame.startGame();

        // then
        assertThat(getPlayerPosition(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("사다리게임을 시작하면 플레이어가 오른쪽으로 움직일 수 있으면 오른쪽으로 움직인다.")
    void givenLadder_whenStartGame_thenReturnRightMoveResult() {
        // when
        ladderGame.startGame();

        // then
        assertThat(getPlayerPosition(0)).isEqualTo(1);
    }

    private int getPlayerPosition(final int index) {
        return players.getPlayers().get(index).getPosition();
    }
}
