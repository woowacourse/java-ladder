package domain;

import domain.ladder.Ladder;
import domain.ladder.RandomPointGenerator;
import domain.players.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void before() {
        List<String> playerNames = List.of("a", "b", "c");
        int ladderHeight = 10;
        Players players = Players.valueOf(playerNames);
        ladderGame = new LadderGame(players, ladderHeight, new RandomPointGenerator());
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
        List<String> playerNames = ladderGame.getPlayers().getPlayerNames();
        assertThat(playerNames).containsExactly("a", "b", "c");
    }

}
