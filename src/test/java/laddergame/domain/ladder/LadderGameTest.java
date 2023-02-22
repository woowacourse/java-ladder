package laddergame.domain.ladder;

import laddergame.domain.player.Players;
import laddergame.domain.prize.Prize;
import laddergame.domain.prize.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static laddergame.domain.ladder.LadderFixture.ethan;
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
        final Players gameResult = ladderGame.startGame();

        // then
        assertAll(
                () -> assertThat(gameResult.getPlayerSize()).isEqualTo(3),
                () -> assertThat(getPosition(gameResult, 1)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("사다리게임을 시작하면 플레이어가 오른쪽으로 움직일 수 있으면 오른쪽으로 움직인다.")
    void givenLadder_whenStartGame_thenReturnRightMoveResult() {
        // when
        final Players gameResult = ladderGame.startGame();

        // then
        assertAll(
                () -> assertThat(gameResult.getPlayerSize()).isEqualTo(3),
                () -> assertThat(getPosition(gameResult, 0)).isEqualTo(1)
        );
    }

    private int getPosition(final Players gameResult, final int index) {
        return gameResult.getPlayers().get(index).getPosition();
    }

    @Test
    @DisplayName("사다리 게임을 시작하고 개인의 결과를 요청하면 결과가 반환된다.")
    void givenLadderGame_whenFindIndividualResult_thenReturnResult() {
        //given
        ladderGame.startGame();

        // when
        final Result result = ladderGame.findIndividualResult("에단");

        // then
        assertAll(
                () -> assertThat(result.getPlayers()).hasSize(1),
                () -> assertThat(result.getPlayers()).containsExactly(ethan),
                () -> assertThat(result.getPrizes()).hasSize(1),
                () -> assertThat(result.getPrizes()).containsExactly(new Prize("5000"))
        );
    }
}
