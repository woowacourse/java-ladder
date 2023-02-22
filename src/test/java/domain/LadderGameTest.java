package domain;

import domain.ladder.ExistPointGenerator;
import domain.ladder.Ladder;
import domain.players.Players;
import domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void before() {
        List<String> playerNames = List.of("a", "b", "c");
        int ladderHeight = 5;
        Players players = Players.valueOf(playerNames);
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
        List<String> playerNames = List.of("a", "b", "c");
        Players players = Players.valueOf(playerNames);
        List<String> prizes = List.of("10000", "20000", "30000", "40000");
        assertThatThrownBy(() -> new LadderGame(players, 5, prizes, new ExistPointGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 수와 당첨 항목의 수는 같아야합니다.");
    }

}
