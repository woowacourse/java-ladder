package domain;

import domain.ladder.Ladder;
import domain.ladder.common.Direction;
import domain.ladder.common.Height;
import domain.player.Name;
import domain.player.Names;
import domain.player.Player;
import domain.player.Players;

import util.RandomDirectionGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

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

        assertThatCode(() -> new GameBoard(players, ladder, rewards))
                .doesNotThrowAnyException();
    }

    /**
     * R L
     * D D
     * R L
     */
    @Test
    @DisplayName("플레이어 이름을 통해 게임을 진행한다 - pobi 는 꽝에 당첨된다")
    public void gameOnePlayer_case1() {
        Players players = 플레이어_생성(Names.from(List.of("pobi", "honux")));
        Rewards rewards = 보상_목록_생성(List.of("꽝", "5000"));
        Height height = new Height("3");
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new FixedDirectionGenerator(List.of(
                Direction.RIGHT, Direction.DOWN, Direction.RIGHT,
                Direction.LEFT, Direction.DOWN, Direction.LEFT)));
        GameBoard gameBoard = new GameBoard(players, ladder, rewards);

        Name name = new Name("pobi");
        Player player = gameBoard.findPlayerWithName(name);

        Result result = gameBoard.playGameOnePlayer(player);
        assertResult("꽝", result);
    }

    @Test
    @DisplayName("플레이어 이름을 통해 게임을 진행한다. - jk 는 5000원에 당첨된다")
    public void gameOnePlayer_case2() {
        Players players = 플레이어_생성(Names.from(List.of("pobi", "honux", "crong", "jk")));
        Rewards rewards = 보상_목록_생성(List.of("꽝", "5000", "꽝", "3000"));
        final var gameBoard = 게임보드_생성(players, rewards);

        Name name = new Name("jk");
        Player player = gameBoard.findPlayerWithName(name);

        Result result = gameBoard.playGameOnePlayer(player);
        assertResult("5000", result);
    }

    private void assertResult(String value, Result result) {
        assertEquals(value, result.reward()
                                  .getValue());
    }

    /**
     * R    L    R   L
     * D    R    L   D
     * R    L    D   D
     * D    R    L   D
     * R    L    R   L
     * 꽝  5000  꽝  3000
     */
    private static GameBoard 게임보드_생성(final Players players, final Rewards rewards) {
        Height height = new Height("5");

        Ladder ladder = new Ladder(height, players.getPlayerCount(), new FixedDirectionGenerator(List.of(
                Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN, Direction.RIGHT,
                Direction.LEFT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT,
                Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.LEFT, Direction.RIGHT,
                Direction.LEFT, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.LEFT)));
        GameBoard gameBoard = new GameBoard(players, ladder, rewards);
        return gameBoard;
    }


    private Players 플레이어_생성(Names names) {
        return new Players(names);
    }

    private Rewards 보상_목록_생성(List<String> rewards) {
        return Rewards.from(rewards, rewards.size());
    }
}
