import domain.Height;
import domain.Ladder;
import domain.Names;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderController {

    public static void main(String[] args) {
        final Names names = retryOnException(LadderController::getNames);
        final Height height = retryOnException(LadderController::getHeight);

        final int width = names.names().size() - 1;
        final Ladder ladder = new Ladder(width, height.height());

        OutputView.printResult(names, ladder);
    }

    private static Names getNames() {
        return new Names(InputView.readNames());
    }

    private static Height getHeight() {
        return new Height(InputView.readHeight());
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
