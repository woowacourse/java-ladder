package controller;

import domain.*;
import domain.ladder.Ladder;
import domain.ladder.attirbute.Height;
import domain.player.Names;
import domain.player.Players;
import util.RandomDirectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    public void execute() {
        Names names = new Names(InputView.inputPlayerNames());
        Height height = new Height(InputView.inputHeight());

        Players players = new Players(names);
        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder);

        printResult(gameBoard);
    }

    private void printResult(GameBoard gameBoard) {
        OutputView.printPlayerNames(gameBoard.getPlayers()
                                             .getPlayerNames());
        IntStream.range(0, gameBoard.getLadderHeight())
                 .mapToObj(gameBoard::getDirectionAtHorizontalIndex)
                 .forEach(OutputView::printDirections);
    }
}
