package ladder.controller;

import ladder.view.Result;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionProcess {

    private final Result result;

    public ExceptionProcess(Result result) {
        this.result = result;
    }

    public <In, Out> Out repeat(Supplier<In> inputSupplier, Function<In, Out> resultFunction) {
        Out out = null;
        while (out == null) {
            out = newOrNull(inputSupplier, resultFunction);
        }
        return out;
    }

    private <In, Out> Out newOrNull(Supplier<In> inputSupplier, Function<In, Out> resultFunction) {
        try {
            In in = inputSupplier.get();
            return resultFunction.apply(in);
        } catch (IllegalArgumentException e) {
            result.printError(e.getMessage());
            return null;
        }
    }

}
