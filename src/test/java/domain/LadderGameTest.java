package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestDataManager;

class LadderGameTest {

    private static final String PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE = "게임 참여자와 결과의 개수는 동일하여야 합니다.";

    @DisplayName("사다리 게임의 참여자와 결과의 개수는 다를 수 없다.")
    @Test
    void createLadderGameMismatchPlayerAndResultSizeFail() {
        PlayerNames playerNames = PlayerNames.of("pobi,crong", ",");
        Players players = Players.from(playerNames);
        ResultContents resultContents = ResultContents.of("꽝,5000,꽝꽝꽝", ",");
        Ladder ladder = TestDataManager.ladderFromHeight(5);

        assertThatThrownBy(() ->
                new LadderGame(ladder, players, resultContents)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE);
    }

    @Test
    void runGameTest() {
        LadderGame ladderGame = TestDataManager.getLadderGame();
        ladderGame.buildBridges();
        ladderGame.runGame();

        assertThat(ladderGame.getResultByPlayerName("pobi")).extracting("content").isEqualTo("5000");
        assertThat(ladderGame.getResultByPlayerName("crong")).extracting("content").isEqualTo("꽝");
        assertThat(ladderGame.getResultByPlayerName("royce")).extracting("content").isEqualTo("10000");
    }


}
