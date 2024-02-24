import domain.Ladder;
import domain.Names;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderController {

    public static void main(String[] args) {
        final String[] rawNames = retryOnException(InputView::readNames);
        final int height = retryOnException(InputView::readHeight);

        final Names names = new Names(rawNames);
        final int width = names.names().size() - 1;
        final Ladder ladder = new Ladder(width, height);

        OutputView.printResult(names, ladder);
    }

    private static <T> T retryOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return retryOnException(supplier);
        }
    }
}
