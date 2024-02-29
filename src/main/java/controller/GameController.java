package controller;

import domain.GameBoard;
import domain.ladder.Ladder;
import domain.ladder.attirbute.Height;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.player.Players;
import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import util.RandomDirectionGenerator;
import view.OutputView;

import java.util.Map;
import java.util.stream.IntStream;

import static util.InputRetryHelper.inputRetryHelper;
import static util.UserMessage.*;
import static view.InputView.input;
import static view.InputView.inputNames;


public class GameController {
    public void execute() {
        Players players = inputRetryHelper(() -> new Players(new PlayerNames(inputNames(PLAYER_INPUT_PROMPT))));
        int numberOfPlayers = players.getPlayerCount();
        PrizeNames prizeNames = inputRetryHelper(() -> new PrizeNames(inputNames(PRIZE_INPUT_PROMPT), numberOfPlayers));
        Height height = inputRetryHelper(() -> new Height(input(HEIGHT_INPUT_PROMPT)));
        Ladder ladder = new Ladder(height, numberOfPlayers, new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, prizeNames);

        printGeneratedGameBoard(gameBoard);
        showGeneratedResult(gameBoard);
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
    }

    private void showGeneratedResult(GameBoard gameBoard) {
        boolean repeatFlag = true;
        while (repeatFlag) {
            OutputView.printNewLine();
            PlayerName targetPlayerName = inputRetryHelper(() -> new PlayerName(input(SEARCH_PLAYER_PROMPT)));
            repeatFlag = showResultAndDetermineRepeat(gameBoard, targetPlayerName);
        }
    }

    private boolean showResultAndDetermineRepeat(GameBoard gameBoard, PlayerName targetPlayerName) {
        OutputView.print(GAME_RESULT_HEADER);
        if (targetPlayerName.isAll()) {
            Map<PlayerName, PrizeName> searchResults = gameBoard.searchAllPlayerResult();
            searchResults.forEach((name, prizeName) -> OutputView.printAllResults(name.getValue(), prizeName.getValue()));
            return false;
        }
        OutputView.print(gameBoard.searchOnePlayerResult(targetPlayerName));
        return true;
    }
}
