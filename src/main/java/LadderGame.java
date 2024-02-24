import domain.Height;
import domain.Ladder;
import domain.Names;
import domain.Prizes;
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
}
