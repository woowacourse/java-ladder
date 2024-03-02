package ladder.controller.util;

import java.util.function.Supplier;
import ladder.view.OutputView;

public class RepeatUtil {

    public static <T> T repeatUntilValid(Supplier<T> function, OutputView outputView) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return repeatUntilValid(function, outputView);
        }
    }
}
