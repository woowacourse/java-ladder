package ladder.controller;

import ladder.view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public class IllegalArgumentExceptionHandler {

    public static <Input, Output> Output repeatUntilNoException(final Supplier<Input> supplier,
                                                                final Function<Input, Output> function,
                                                                OutputView outputView) {
        Output output = null;

        while (output == null) {
            output = createOutputOrNull(supplier, function, outputView);
        }
        return output;
    }

    public static <Input, Output> Output createOutputOrNull(final Supplier<Input> inputSupplier,
                                                            final Function<Input, Output> function,
                                                            OutputView outputView) {
        try {
            Input input = inputSupplier.get();
            return function.apply(input);

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return null;
        }
    }

}
