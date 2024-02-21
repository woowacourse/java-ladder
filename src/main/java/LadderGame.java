import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.RandomBridgeConstructStrategy;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public static void run() {
        List<Name> names = readNames();
        Height height = readHeight();

        Ladder ladder = new Ladder(new RandomBridgeConstructStrategy(), names.size(), height);

        OutputView.printNames(names);
        OutputView.printLadder(ladder);
    }

    private static List<Name> readNames() {
        try {
            return InputView.readPersonNames()
                    .stream()
                    .map(Name::new)
                    .toList();
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
