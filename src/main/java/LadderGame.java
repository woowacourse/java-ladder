import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prizes;
import domain.Result;
import domain.Results;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private LadderGame() {
    }

    public static void run() {
        Names names = readNames();
        OutputView.printNewLine();
        Prizes prizes = readPrizes(names);
        OutputView.printNewLine();
        Height height = readHeight();
        OutputView.printNewLine();

        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names, prizes, height);

        OutputView.printNames(names);
        OutputView.printLadder(ladder);
        OutputView.printPrizes(prizes);
        OutputView.printNewLine();

        printResult(names, ladder);

    }

    // TODO 반복 메서드 추출
    private static Names readNames() {
        try {
            return new Names(InputView.readPersonNames());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readNames();
        }
    }

    private static Prizes readPrizes(Names names) {
        try {
            return new Prizes(InputView.readPrizes(), names);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readPrizes(names);
        }
    }

    private static Height readHeight() {
        try {
            return new Height(InputView.readHeight());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readHeight();
        }
    }

    private static void printResult(Names names, Ladder ladder) {
        while (true) {
            Name targetName = readTarget(names, ladder);
            if (targetName == null) {
                return;
            }
            Result result = ladder.calculateResult(targetName);
            OutputView.printResult(result);
            OutputView.printNewLine();
        }
    }

    private static Name readTarget(Names names, Ladder ladder) {
        try {
            String target = readResultTarget();
            if (target.equals("all")) {
                Results results = ladder.calculateAllResult();
                OutputView.printNewLine();
                OutputView.printResults(results);
                return null;
            }
            return names.findNameByString(target);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readTarget(names, ladder);
        }
    }

    private static String readResultTarget() {
        try {
            return InputView.readResultTarget();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readResultTarget();
        }
    }
}
