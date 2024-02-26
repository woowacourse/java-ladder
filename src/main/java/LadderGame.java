import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prizes;
import domain.Result;
import domain.Results;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private LadderGame() {
    }

    public static void run() {
        Names names = repeat(() -> new Names(InputView.readPersonNames()));
        OutputView.printNewLine();
        Prizes prizes = repeat(() -> new Prizes(InputView.readPrizes(), names));
        OutputView.printNewLine();
        Height height = repeat(() -> new Height(InputView.readHeight()));
        OutputView.printNewLine();

        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names, prizes, height);

        OutputView.printNames(names);
        OutputView.printLadder(ladder);
        OutputView.printPrizes(prizes);
        OutputView.printNewLine();

        repeat(() -> printResult(names, ladder));
    }

    private static void printResult(Names names, Ladder ladder) {
        while (true) {
            String target = InputView.readResultTarget();
            if (target.equals("all")) {
                Results results = ladder.calculateAllResult();
                OutputView.printNewLine();
                OutputView.printResults(results);
                return;
            }
            Name targetName = names.findNameByString(target);
            Result result = ladder.calculateResult(targetName);
            OutputView.printResult(result);
            OutputView.printNewLine();
        }
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
