package ladder.controller;

import ladder.view.ResultView;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionProcess {

    private final ResultView resultView;

    public ExceptionProcess(ResultView resultView) {
        this.resultView = resultView;
    }

    public <Input, Result> Result repeat(Supplier<Input> inputSupplier, Function<Input, Result> resultFunction) {
        Result result = null;
        while (result == null) {
            result = newOrNull(inputSupplier, resultFunction);
        }
        return result;
    }

    private <Input, Result> Result newOrNull(Supplier<Input> inputSupplier, Function<Input, Result> resultFunction) {
        try {
            Input input = inputSupplier.get();
            return resultFunction.apply(input);
        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }

}
