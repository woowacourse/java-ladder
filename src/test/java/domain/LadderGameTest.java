package domain;

import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

import java.security.SecureRandom;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void beforeEach() {
        Players players = Players.from(List.of("pobi", "crong"));
        Height height = new Height(5);
        Rewards rewards = Rewards.from(players.getSize(), List.of("fail", "5000"));
        Ladder ladder = Ladder.of(players.getSize(), height, createCustomRandomNumberGenerator());
        Point startPoint = ladder.getPoint(0, 0);
        Point endPoint = ladder.getPoint(0, 1);
        ladder.buildBridge(startPoint, endPoint);
        ladderGame = new LadderGame(ladder, players, rewards);
    }

    @Test
    @DisplayName("사다리 타기를 진행한 뒤 상품을 확인한다.")
    void getResultsAllSuccess() {
        Command command = new Command("all");

        List<Result> results = ladderGame.getResults(command).getResults();
        Result firstResult = results.get(0);
        Result secondResult = results.get(1);

        assertThat(firstResult.getPlayerName()).isEqualTo("pobi");
        assertThat(firstResult.getRewardName()).isEqualTo("5000");
        assertThat(secondResult.getPlayerName()).isEqualTo("crong");
        assertThat(secondResult.getRewardName()).isEqualTo("fail");
    }

    @Test
    @DisplayName("사다리 타기를 진행한 뒤 상품을 확인한다.")
    void getResultSuccess() {
        Command command = new Command("crong");

        List<Result> results = ladderGame.getResults(command).getResults();

        assertThat(results).hasSize(1);
        assertThat(results.get(0).getPlayerName()).isEqualTo("crong");
        assertThat(results.get(0).getRewardName()).isEqualTo("fail");
    }

    private RandomNumberGenerator createCustomRandomNumberGenerator() {
        return new RandomNumberGenerator(new SecureRandom() {
            @Override
            public int nextInt(int value) {
                return 0;
            }
        });
    }

}
