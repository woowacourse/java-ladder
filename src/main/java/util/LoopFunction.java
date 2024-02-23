package util;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class LoopFunction<T> {

    private final Supplier<T> function;

    private T returnValue = null;

    public LoopFunction(Supplier<T> function) {
        this.function = function;
    }

    public static <T> T retryOnException(Supplier<T> function) {
        LoopFunction<T> loopFunction = new LoopFunction<>(function);
        return Stream.iterate(loopFunction, LoopFunction::setReturnValueOnSuccess)
                .filter(LoopFunction::hasReturnValue)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getReturnValue();
    }

    private static <T> LoopFunction<T> setReturnValueOnSuccess(LoopFunction<T> loopFunction) {
        try {
            T returnValue = loopFunction.invoke();
            loopFunction.setReturnValue(returnValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return loopFunction;
    }

    public T invoke() {
        return function.get();
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(T value) {
        this.returnValue = value;
    }

    public boolean hasReturnValue() {
        return returnValue != null;
    }
}