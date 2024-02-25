import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Names;
import domain.ladder.bridgeConstructstrategy.RandomBridgeConstructStrategy;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private LadderGameController() {
    }

    public static void run() {
        Names names = readNames();
        OutputView.printNewLine();
        Height height = readHeight();
        OutputView.printNewLine();

        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names, height);

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
