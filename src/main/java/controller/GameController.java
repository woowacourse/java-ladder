package controller;

import static util.InputRetryHelper.inputRetryHelper;
import static util.UserMessage.GAME_RESULT_HEADER;
import static util.UserMessage.HEIGHT_INPUT_PROMPT;
import static util.UserMessage.LADDER_GENERATE_RESULT_HEADER;
import static util.UserMessage.PLAYER_INPUT_PROMPT;
import static util.UserMessage.PRIZE_INPUT_PROMPT;
import static util.UserMessage.SEARCH_PLAYER_PROMPT;
import static view.InputView.input;
import static view.InputView.inputNames;

import domain.GameBoard;
import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.ladder.attirbute.Height;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.player.Players;
import domain.prize.PrizeNames;
import java.util.List;
import util.RandomDirectionGenerator;
import view.OutputView;


public class GameController {
    public void execute() {
        Players players = inputRetryHelper(() -> new Players(new PlayerNames(inputNames(PLAYER_INPUT_PROMPT))));
        int numberOfPlayers = players.getPlayerCount();
        PrizeNames prizeNames = inputRetryHelper(() -> new PrizeNames(inputNames(PRIZE_INPUT_PROMPT), numberOfPlayers));
        Height height = inputRetryHelper(() -> new Height(input(HEIGHT_INPUT_PROMPT)));
        Ladder ladder = new Ladder(height, numberOfPlayers, new RandomDirectionGenerator());
        GameBoard gameBoard = new GameBoard(players, ladder, prizeNames);

        showGeneratedGameBoard(gameBoard);
        showGeneratedResult(gameBoard);
    }

    private void showGeneratedGameBoard(GameBoard gameBoard) {
        OutputView.print(LADDER_GENERATE_RESULT_HEADER);
        OutputView.printNewLine();
        OutputView.printObjectNames(gameBoard.getGamePlayerNames());
        for (int currentIndex = 0; currentIndex < gameBoard.getLadderHeight(); currentIndex++) {
            List<Direction> directions = gameBoard.getDirectionsAtHorizontalIndex(currentIndex);
            OutputView.printDirections(directions);
        }
        OutputView.printObjectNames(gameBoard.getPrizeNames());
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
            gameBoard.searchAllPlayerResult()
                    .forEach(
                            (name, prizeName) -> OutputView.printAllResults(name.getValue(), prizeName.getValue()));
            return false;
        }
        OutputView.print(gameBoard.searchOnePlayerResult(targetPlayerName));
        return true;
    }
}
