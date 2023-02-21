package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void init() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        int numberOfPlayer = players.getNumberOfPlayer();
        Rewards rewards = new Rewards(List.of("꽝", "5000", "꽝", "3000"), numberOfPlayer);
        LadderGenerator ladderGenerator = new LadderGenerator(
                new TestBooleanGenerator(
                        Lists.newArrayList(true, true, false, true, true, false, false, true, true, true)
                )
        );
        Ladder ladder = ladderGenerator.generateLadder(5, numberOfPlayer);
        ladderGame = new LadderGame(ladder, players, rewards);
    }

    @ParameterizedTest
    @CsvSource({"pobi,꽝", "honux,3000", "crong,꽝", "jk,5000"})
    void df(String playerName, String rewardName) {
        Name name = new Name(playerName);
        Map reward = ladderGame.getReward(name);
        assertThat(reward).contains(
                entry(playerName, rewardName)
        );
    }

    @Test
    void dfd() {
        Name name = new Name("all");
        Map reward = ladderGame.getReward(name);
        assertThat(reward).contains(
                entry("pobi", "꽝"),
                entry("honux", "3000"),
                entry("crong", "꽝"),
                entry("jk", "5000")
        );
    }
}
