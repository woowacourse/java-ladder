package domain;

import factory.LadderFactory;
import factory.PlayersFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void before() {
        List<String> playerNames = List.of("a", "b", "c");
        Players players = PlayersFactory.generate(playerNames);
        int ladderHeight = 10;
        Ladder ladder = LadderFactory.generate(playerNames.size(), ladderHeight);
        ladderGame = new LadderGame(players, ladder);
    }

    @DisplayName("Ladder를 생성한다.")
    @Test
    void generateLadder() {
        Ladder ladder = ladderGame.getLadder();
        assertThat(ladder.getLines().size()).isEqualTo(10);
    }

    @DisplayName("Players를 생성한다.")
    @Test
    void generatePlayers() {
        List<String> playerNames = ladderGame.getPlayerNames();
        assertThat(playerNames).containsExactly("a", "b", "c");
    }

}
