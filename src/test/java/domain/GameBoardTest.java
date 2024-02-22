package domain;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.common.Height;
import domain.player.Name;
import domain.player.Names;
import domain.player.Player;
import domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomDirectionGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GameBoardTest {
    @Test
    @DisplayName("Player 와 사다리를 통해 게임 보드를 만든다.")
    public void createGameBoard() {
        Players players = 플레이어_생성(Names.from(List.of("도비", "조이썬", "포비", "크롱")));

        Height height = new Height("5");
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());

        GameBoard gameBoard = new GameBoard(players, ladder);

        assertInstanceOf(GameBoard.class, gameBoard);

    }

    private Players 플레이어_생성(Names names) {
        return new Players(names);
    }
}
