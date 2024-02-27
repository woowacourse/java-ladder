import domain.db.Player;
import domain.db.Players;
import domain.db.Prize;
import domain.db.Prizes;
import domain.game.Judge;
import domain.game.LadderGame;
import domain.game.PathMapper;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.RandomBridgeMakingStrategy;
import view.InputView;
import view.OutputView;

import java.util.Map;
import java.util.function.Supplier;

public class LadderController {

    public static void main(String[] args) {
        final Players players = retryOnException(LadderController::getNames);
        final Prizes prizes = retryOnException(LadderController::getPrizes);
        final Height height = retryOnException(LadderController::getHeight);

        final Ladder ladder = makeLadder(players, height);
        final PathMapper pathMapper = LadderGame.play(ladder);
        final Judge judge = new Judge(players, prizes, pathMapper);

        OutputView.printLadderGame(players, ladder, prizes);
        searchGameResult(judge);
    }

    private static void searchGameResult(final Judge judge) {
        while (true) {
            try {
                final Map<Player, Prize> result = getPrizeByName(judge);
                OutputView.printSearchResult(result);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static Map<Player, Prize> getPrizeByName(final Judge judge) throws IllegalArgumentException {
        final Player playerToSearch = getNameToSearch();
        return judge.search(playerToSearch.name());
    }

    private static Players getNames() {
        return new Players(InputView.readNames());
    }

    private static Prizes getPrizes() {
        return new Prizes(InputView.readPrizes());
    }

    private static Height getHeight() {
        return new Height(InputView.readHeight());
    }

    private static Player getNameToSearch() {
        return new Player(InputView.readNameToSearch());
    }

    private static Ladder makeLadder(final Players players, final Height height) {
        return new Ladder(players.size() - 1, height.value(), new RandomBridgeMakingStrategy());
    }

    private static <T> T retryOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            OutputView.printErrorMessage(e);
            return retryOnException(supplier);
        }
    }
}
