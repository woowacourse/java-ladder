package laddergame;

import java.util.List;
import laddergame.domain.Game;
import laddergame.domain.GameResult;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.RandomStickGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

class Controller {

    private static final String ALL_RESULT_COMMAND = "all";

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Game game = createGame();
        outputView.printLadder(game);
        play(game, inputView.readNameForResult());
    }

    private Game createGame() {
        Players players = createPlayers();
        Height height = createHeight();
        List<GameResult> gameResults = createGameResult();
        int playerSize = players.size();
        Ladder ladder = new Ladder(height, playerSize, new RandomStickGenerator());

        return new Game(players, ladder, gameResults);
    }

    private Players createPlayers() {
        List<String> playerNames = inputView.readNames();

        return new Players(playerNames);
    }

    private Height createHeight() {
        int inputHeight = inputView.readHeight();

        return new Height(inputHeight);
    }

    private List<GameResult> createGameResult() {
        List<String> gameResults = inputView.readGameResults();

        return gameResults.stream()
                .map(GameResult::new)
                .toList();
    }

    private void play(Game game, String targetPlayerName) {
        if (ALL_RESULT_COMMAND.equals(targetPlayerName)) {
            outputView.printResultAll(game.showResultAll());
            return;
        }

        outputView.printResult(game.showResult(targetPlayerName));
        play(game, inputView.readNameForResult());
    }
}
