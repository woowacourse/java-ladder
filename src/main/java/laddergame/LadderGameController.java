package laddergame;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Players;
import laddergame.domain.PlayersResults;
import laddergame.domain.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;
import laddergame.view.ReservedWords;

public class LadderGameController {
    private final LadderGameService gameService = new LadderGameService();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        final Players players = requestUntilValidated(this::getPlayers);
        final Results results = requestUntilValidated(() -> getResults(players));
        final Height height = requestUntilValidated(this::getHeight);
        final Ladder ladder = gameService.getLadder(players, height, results);
        outputView.writeLadderResult(players, ladder, results);
        repeatUntil(() -> runCommand(
                requestUntilValidated(() -> inputView.readDesiredPlayerName(players)),
                gameService.getPlayersResults(ladder)));
    }

    private Players getPlayers() {
        final List<String> playersNamesInput = inputView.readPlayersName();
        return gameService.getPlayers(playersNamesInput);
    }

    private Height getHeight() {
        final String heightInput = inputView.readLadderHeight();
        return gameService.getHeight(heightInput);
    }

    private Results getResults(final Players players) {
        final List<String> resultNamesInput = inputView.readResultNames();
        return gameService.getResults(resultNamesInput, players.getPlayersSize());
    }


    private boolean runCommand(final String name, final PlayersResults playersResults) {
        if (ReservedWords.isIncluded(name)) {
            outputView.writeAllResults(playersResults);
            return true;
        }
        outputView.writeDesiredResult(playersResults.find(name));
        return false;
    }

    private <T> T requestUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.writeErrorMessage(e.getMessage());
            return requestUntilValidated(supplier);
        }
    }

    private void repeatUntil(BooleanSupplier condition) {
        while (!condition.getAsBoolean()) {
        }
    }
}
