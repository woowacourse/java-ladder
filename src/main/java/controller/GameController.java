package controller;

import domain.GameBoard;
import domain.Rewards;
import domain.ladder.Ladder;
import domain.ladder.common.Height;
import domain.player.Names;
import domain.player.Players;
import util.RandomDirectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.stream.IntStream;

public class GameController {
    public void execute() {
        Names names = Names.from(InputView.inputPlayerNames());
        Players players = new Players(names);

        Rewards rewards = Rewards.from(InputView.inputRewards(), players.getPlayerCount());

        Height height = new Height(InputView.inputHeight());


        Ladder ladder = new Ladder(height, players.getPlayerCount(), new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, rewards);

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
