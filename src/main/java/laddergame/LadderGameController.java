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
    private final LadderGameBuilder ladderBuilder = new LadderGameBuilder();
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        final Players players = requestUntilValidated(this::createPlayers);
        final Results results = requestUntilValidated(() -> createResults(players));
        final Height height = requestUntilValidated(this::createHeight);
        final Ladder ladder = ladderBuilder.createLadder(players, height, results);
        outputView.writeLadderResult(players, ladder, results);
        repeatUntil(() -> runCommand(
                requestUntilValidated(() -> inputView.readDesiredPlayerName(players)),
                ladderBuilder.createPlayersResults(ladder)));
    }

    private Players createPlayers() {
        final List<String> playersNamesInput = inputView.readPlayersName();
        return ladderBuilder.createPlayers(playersNamesInput);
    }

    private Height createHeight() {
        final String heightInput = inputView.readLadderHeight();
        return ladderBuilder.createHeight(heightInput);
    }

    private Results createResults(final Players players) {
        final List<String> resultNamesInput = inputView.readResultNames();
        return ladderBuilder.createResults(resultNamesInput, players.getPlayersSize());
    }


    private boolean runCommand(final String userInput, final PlayersResults playersResults) {
        if (ReservedWords.isReserved(userInput)) {
            outputView.writeAllResults(playersResults);
            return true;
        }
        outputView.writeDesiredResult(playersResults.find(userInput));
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
