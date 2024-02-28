package laddergame;

import laddergame.domain.*;
import laddergame.util.RandomLinesGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.function.Supplier;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = retryUntilValidated(() -> new Players(inputView.readPlayersName()));
        Height height = retryUntilValidated(() -> new Height(inputView.readLadderHeight()));

        Ladder ladder = new Ladder(new RandomLinesGenerator(),
                players.getPlayersCount(),
                height);

        LadderGame ladderGame = retryUntilValidated(() ->
                new LadderGame(players, ladder, inputView.readLadderResult()));
        ladderGame.climb();
        ladderGame.calculatePlayersItem();

        printLadderResult(ladderGame);

        while (true) {
            try {
                String name = inputView.readPlayerNameWantToSeeResult();
                if (name.equals("all")) {
                    outputView.writeAllResultItems(players);
                    break;
                }
                ResultItem item = players.findItemByName(name);
                outputView.writeResultItem(item);
            } catch (IllegalArgumentException e) {
                OutputView.writeErrorMessage(e.getMessage());
            }
        }
    }

    private void printLadderResult(final LadderGame ladderGame) {
        outputView.writeResultTitle();
        outputView.writePlayersName(ladderGame.getPlayers());
        outputView.writeLadder(ladderGame.getLadder());
        outputView.writeResultItems(ladderGame.getItems());
    }

    private <T> T retryUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.writeErrorMessage(e.getMessage());
            return retryUntilValidated(supplier);
        }
    }
}
