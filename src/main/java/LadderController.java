import domain.game.Judge;
import domain.game.LadderGame;
import domain.game.PathMapper;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Players;
import domain.prize.Prizes;
import domain.strategy.RandomBridgeMakingStrategy;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final Players players = retryOnException(LadderController::getNames);
        final Prizes prizes = retryOnException(LadderController::getPrizes);
        final Height height = retryOnException(LadderController::getHeight);

        final Ladder ladder = makeLadder(players, height);
        final PathMapper pathMapper = LadderGame.play(ladder);
        final Judge judge = new Judge(players, prizes, pathMapper);

        outputView.printLadderGame(players, ladder, prizes);
        searchGameResult(judge);
    }

    private static void searchGameResult(final Judge judge) {
        do {
            final String name = inputView.readNameToSearch();
            if ("END".equals(name)) {
                return;
            }
            try {
                outputView.printSearchResult(judge.search(name));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        } while (true);
    }

    private static Players getNames() {
        return new Players(inputView.readNames());
    }

    private static Prizes getPrizes() {
        return new Prizes(inputView.readPrizes());
    }

    private static Height getHeight() {
        return new Height(inputView.readHeight());
    }

    private static Ladder makeLadder(final Players players, final Height height) {
        return new Ladder(players.size() - 1, height.value(), new RandomBridgeMakingStrategy());
    }

    private static <T> T retryOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            return retryOnException(supplier);
        }
    }
}
