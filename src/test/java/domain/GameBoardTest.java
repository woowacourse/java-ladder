package domain;

import domain.ladder.Ladder;
import domain.ladder.attirbute.Height;
import domain.player.Names;
import domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomDirectionGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;


class GameBoardTest {
    @Test
    @DisplayName("Player 와 사다리를 통해 게임 보드를 만든다.")
    void createGameBoard() {
        Players players = 플레이어_생성(new Names(List.of("도비", "조이썬", "포비", "크롱")));

        Height height = new Height("5");
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        Prizes prizes = new Prizes(List.of("꽝", "꽝", "꽝", "꽝"), 4);
        GameBoard gameBoard = new GameBoard(players, ladder, prizes);

        assertInstanceOf(GameBoard.class, gameBoard);

    }

    private Players 플레이어_생성(Names names) {
        return new Players(names);
    }
}
