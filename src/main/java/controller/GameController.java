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
        Names names = new Names(inputNames(PLAYER_INPUT_PROMPT));
        Players players = new Players(names);
        int numberOfPlayers = players.getPlayerCount();
        Prizes prizes = new Prizes(inputNames(PRIZE_INPUT_PROMPT), numberOfPlayers);
        Height height = new Height(inputHeight());

        Ladder ladder = new Ladder(height, numberOfPlayers, new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, prizes);

        printGeneratedLadderResult(gameBoard);
    }

    private void printGeneratedLadderResult(GameBoard gameBoard) {
        System.out.println(LADDER_GENERATE_RESULT_HEADER);
        System.out.println(System.lineSeparator());
        OutputView.printObjectNames(gameBoard.getPlayers()
                                             .getPlayerNames());
        IntStream.range(0, gameBoard.getLadderHeight())
                 .mapToObj(gameBoard::getDirectionAtHorizontalIndex)
                 .forEach(OutputView::printDirections);
        OutputView.printObjectNames(gameBoard.getPrizes()
                                             .getValue());
    }
}
