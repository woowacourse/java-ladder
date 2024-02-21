import domain.Height;
import domain.Ladder;
import domain.Names;
import domain.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public static void run() {
        Names names = readNames();
        OutputView.printNewLine();
        Height height = readHeight();
        OutputView.printNewLine();

        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names.size(), height);

        OutputView.printNames(names);
        OutputView.printLadder(ladder);
    }

    private static Names readNames() {
        try {
            return new Names(InputView.readPersonNames());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readNames();
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
