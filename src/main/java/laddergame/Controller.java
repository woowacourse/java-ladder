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
        play(game);
    }

    private Game createGame() {
        Players players = createPlayers();
        Height height = createHeight();
        List<GameResult> gameResults = createGameResult();
        Ladder ladder = new Ladder(height, players.size(), new RandomStickGenerator());

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

    private void play(Game game) {
        String targetPlayerName = inputView.readNameForResult();

        while (!ALL_RESULT_COMMAND.equals(targetPlayerName)) {
            outputView.printResult(game.showResult(targetPlayerName));
            targetPlayerName = inputView.readNameForResult();
        }

        outputView.printResultAll(game.showResultAll());
    }
}
