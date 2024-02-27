package controller;

import domain.GameBoard;
import domain.Prizes;
import domain.ladder.Ladder;
import domain.ladder.attirbute.Height;
import domain.player.Names;
import domain.player.Players;
import util.RandomDirectionGenerator;
import view.OutputView;

import java.util.stream.IntStream;

import static view.InputView.inputHeight;
import static view.InputView.inputNames;
import static view.UserMessage.*;


public class GameController {
    public void execute() {
        Players players = new Players(new Names(inputNames(PLAYER_INPUT_PROMPT)));
        int numberOfPlayers = players.getPlayerCount();
        Prizes prizes = new Prizes(inputNames(PRIZE_INPUT_PROMPT), numberOfPlayers);

        Ladder ladder = new Ladder(new Height(inputHeight()), numberOfPlayers, new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, prizes);

        printGeneratedGameBoard(gameBoard);
    }

    private void printGeneratedGameBoard(GameBoard gameBoard) {
        OutputView.print(LADDER_GENERATE_RESULT_HEADER);
        OutputView.printNewLine();
        OutputView.printObjectNames(gameBoard.getPlayers()
                                             .getPlayerNames());
        IntStream.range(0, gameBoard.getLadderHeight())
                 .mapToObj(gameBoard::getDirectionsAtHorizontalIndex)
                 .forEach(OutputView::printDirections);
        OutputView.printObjectNames(gameBoard.getPrizes()
                                             .getValue());
        OutputView.printNewLine();
    }
}
