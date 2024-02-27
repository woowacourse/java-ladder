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

        ResultItems items = retryUntilValidated(() -> new ResultItems(inputView.readLadderResult(), players.getPlayersCount()));
        LadderGame ladderGame = new LadderGame(players, ladder, items);
        ladderGame.climb();
        ladderGame.calculatePlayersItem();

        printLadderResult(players, ladder, items);

        while (true) {
            try {
                String name = inputView.readPlayerNameWantToSeeResult();
                if (name.equals("all")) {
                    outputView.writeAllResultItems(players);
                    break;
                }
                String item = players.findItemByName(name);
                outputView.writeResultItem(item);
            } catch (IllegalArgumentException e) {
                OutputView.writeErrorMessage(e.getMessage());
            }
        }
    }

    private void printLadderResult(final Players players, final Ladder ladder, final ResultItems items) {
        outputView.writeResultTitle();
        outputView.writePlayersName(players);
        outputView.writeLadder(ladder, items);
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
