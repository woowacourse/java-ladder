package laddergame.domain.ladder;

import laddergame.domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static laddergame.domain.ladder.LadderFixture.ladder;
import static laddergame.domain.ladder.LadderFixture.players;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderGameTest{

    private LadderFixture fixture;

    @BeforeEach
    void setUp() {
        fixture = new LadderFixture();
    }

    @Test
    @DisplayName("사다리와 플레이어들로 사다리 게임을 만들 수 있다.")
    void givenPlayerAndLadder_whenCreateLadder_thenSuccess() {
        // when
        final LadderGame ladderGame = LadderGame.of(ladder, players);

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
        // given
        final LadderGame ladderGame = LadderGame.of(ladder, players);

        // when
        final List<Player> gameResult = ladderGame.startGame();

        // then
        assertAll(
                () -> assertThat(gameResult.size()).isEqualTo(3),
                () -> assertThat(gameResult.get(1).getPosition()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("사다리게임을 시작하면 플레이어가 오른쪽으로 움직일 수 있으면 오른쪽으로 움직인다.")
    void givenLadder_whenStartGame_thenReturnRightMoveResult() {
        // given
        final LadderGame ladderGame = LadderGame.of(ladder, players);

        // when
        final List<Player> gameResult = ladderGame.startGame();

        // then
        assertAll(
                () -> assertThat(gameResult.size()).isEqualTo(3),
                () -> assertThat(gameResult.get(0).getPosition()).isEqualTo(1)
        );
    }
}
