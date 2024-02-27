import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prizes;
import domain.Result;
import domain.Results;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private LadderGame() {
    }

    public static void run() {
        Names names = repeat(() -> new Names(InputView.readPersonNames()));
        OutputView.printNewLine();
        Prizes prizes = repeat(() -> new Prizes(InputView.readPrizes(), names.size()));
        OutputView.printNewLine();
        Height height = repeat(() -> new Height(InputView.readHeight()));
        OutputView.printNewLine();
        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names, prizes, height);

        handleResult(names, prizes, ladder);
    }

    private static void handleResult(Names names, Prizes prizes, Ladder ladder) {
        OutputView.printNames(names);
        OutputView.printLadder(ladder);
        OutputView.printPrizes(prizes);
        OutputView.printNewLine();
        repeat(() -> handleResult(names, ladder));
    }

    private static void handleResult(Names names, Ladder ladder) {
        String target = InputView.readResultTarget();
        if (target.equals("all")) {
            handleAll(ladder);
            return;
        }
        Name targetName = names.findNameByString(target);
        Result result = ladder.calculateResult(targetName);
        OutputView.printResult(result);
        OutputView.printNewLine();
        handleResult(names, ladder);
    }

    private static void handleAll(Ladder ladder) {
        Results results = ladder.calculateAllResult();
        OutputView.printNewLine();
        OutputView.printResults(results);
    }

    private static <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return repeat(supplier);
        }
    }

    private static void repeat(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            repeat(runnable);
        }
    }
}
