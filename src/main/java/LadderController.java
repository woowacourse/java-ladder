import domain.db.Name;
import domain.db.Names;
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

import static view.OutputView.printLadderGame;

public class LadderController {

    public static void main(String[] args) {
        final Names names = retryOnException(LadderController::getNames);
        final Prizes prizes = retryOnException(LadderController::getPrizes);
        final Height height = retryOnException(LadderController::getHeight);

        final Ladder ladder = getLadder(names, height);
        final PathMapper pathMapper = LadderGame.play(ladder);
        final Judge judge = new Judge(names, prizes, pathMapper);

        printLadderGame(names, ladder, prizes);
        searchGameResult(judge);
    }

    private static void searchGameResult(final Judge judge) {
        while (true) {
            try {
                final Map<Name, Prize> result = getPrizeByName(judge);
                OutputView.printSearchResult(result);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static Map<Name, Prize> getPrizeByName(final Judge judge) throws IllegalArgumentException {
        final Name nameToSearch = getNameToSearch();
        return judge.search(nameToSearch.name());
    }

    private static Ladder getLadder(final Names names, final Height height) {
        final int width = names.names().size() - 1;
        return new Ladder(width, height.height(), new RandomBridgeMakingStrategy());
    }

    private static Names getNames() {
        return new Names(InputView.readNames());
    }

    private static Prizes getPrizes() {
        return new Prizes(InputView.readPrizes());
    }

    private static Height getHeight() {
        return new Height(InputView.readHeight());
    }

    private static Name getNameToSearch() {
        return new Name(InputView.readNameToSearch());
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
