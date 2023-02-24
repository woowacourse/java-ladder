package domain;

import domain.ladder.ExistPointGenerator;
import domain.ladder.Ladder;
import domain.players.Player;
import domain.players.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private Players players;
    private LadderGame ladderGame;

    @BeforeEach
    void before() {
        List<String> playerNames = List.of("a", "b", "c");
        int ladderHeight = 5;
        players = Players.valueOf(playerNames);
        List<String> prizes = List.of("10000", "20000", "30000");
        ladderGame = new LadderGame(players, ladderHeight, prizes, new ExistPointGenerator());
    }

    @DisplayName("Ladder를 생성한다.")
    @Test
    void generateLadder() {
        Ladder ladder = ladderGame.getLadder();
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @DisplayName("Players를 생성한다.")
    @Test
    void generatePlayers() {
        List<String> playerNames = ladderGame.getPlayers().getPlayerNames();
        assertThat(playerNames).containsExactly("a", "b", "c");
    }

    @DisplayName("Prizes를 생성한다.")
    @Test
    void generatePrizes() {
        Prizes prizes = ladderGame.getPrizes();
        assertThat(prizes.getPrizeValues()).containsExactly("10000", "20000", "30000");
    }

    @DisplayName("참여자 수와 당첨항목의 수가 다르면 예외를 던진다.")
    @Test
    void playersSizeAndEntriesSizeSame() {
        List<String> prizes = List.of("10000", "20000", "30000", "40000");
        assertThatThrownBy(() -> new LadderGame(players, 5, prizes, new ExistPointGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 수와 당첨 항목의 수는 같아야합니다.");
    }

    @DisplayName("사다리 게임 전체 결과를 반환한다.")
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    @ParameterizedTest
    void getTotalResult(int playerIndex, int prizeIndex) {
        List<String> playerList = List.of("a", "b", "c");
        Players players = Players.valueOf(playerList);
        List<String> prizes = List.of("10000", "20000", "30000");
        ladderGame = new LadderGame(players, 5, prizes, new ExistPointGenerator());
        LadderGameResult result = this.ladderGame.getResult();
        Map<Player, Prize> totalResult = result.getPlayerToPrize();

        assertThat(totalResult.get(players.getPlayerAt(playerIndex)).getValue())
                .isEqualTo(prizes.get(prizeIndex));
    }

    @DisplayName("개인별 사다리 게임 결과를 반환한다.")
    @CsvSource(value = {"a:20000", "b:10000", "c:30000"}, delimiter = ':')
    @ParameterizedTest
    void getPersonalResult(String playerName, String prizeValue) {
        Prize prize = ladderGame.getPersonalResult(playerName);
        assertThat(prize.getValue()).isEqualTo(prizeValue);
    }

}
