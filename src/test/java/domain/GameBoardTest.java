package domain;

import domain.ladder.Ladder;
import domain.ladder.common.Height;
import domain.player.Names;
import domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomDirectionGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatCode;


public class GameBoardTest {
    @Test
    @DisplayName("플레이어 목록과 보상 목록과 사다리를 통해 게임 보드를 만든다.")
    public void createGameBoard() {
        Players players = 플레이어_생성(Names.from(List.of("도비", "조이썬", "포비", "크롱")));
        Height height = new Height("5");
        Rewards rewards = 보상_목록_생성(List.of("꽝", "5000", "꽝", "3000"));

        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());

        assertThatCode(() -> new GameBoard(players, ladder, rewards));

    }

    private Players 플레이어_생성(Names names) {
        return new Players(names);
    }

    private Rewards 보상_목록_생성(List<String> rewards) {
        return Rewards.from(rewards, rewards.size());
    }
}
