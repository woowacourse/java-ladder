package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Ladder;
import domain.player.PlayerNames;
import domain.player.Players;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestDataManager;

class LadderGameTest {

    private static final String PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE = "게임 참여자와 결과의 개수는 동일하여야 합니다.";

    @Test
    @DisplayName("사다리 게임의 참여자와 결과의 개수는 다를 수 없다.")
    void createLadderGameMismatchPlayerAndResultSizeFail() {
        PlayerNames playerNames = PlayerNames.from(List.of("pobi", "crong"));
        Players players = Players.from(playerNames);
        List<String> resultContentsValue = List.of("꽝", "5000", "꽝꽝꽝");
        ResultContents resultContents = ResultContents.from(resultContentsValue);
        Ladder ladder = TestDataManager.ladderFromHeight(5);

        assertThatThrownBy(() ->
                new LadderGame(ladder, players, resultContents)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_RESULT_SIZE_MISMATCH_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("게임 결과 매칭 테스트")
    void runGameTest() {
        LadderGame ladderGame = TestDataManager.getLadderGame();
        ladderGame.buildBridges();
        ladderGame.runGame();

        assertThat(ladderGame.getResultByPlayerName("pobi")).isEqualTo("5000");
        assertThat(ladderGame.getResultByPlayerName("crong")).isEqualTo("꽝");
        assertThat(ladderGame.getResultByPlayerName("royce")).isEqualTo("10000");
    }


}
