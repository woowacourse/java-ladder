package error;

import java.util.function.Function;
import view.InputView;

public class ErrorHandler {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public <T, R> R readUntilNoError(Function<T, R> function, InputView inputView, String message) {
        try {
            String read = inputView.read(message);
            return function.apply((T) read);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return readUntilNoError(function, inputView, message);
        }
    }
}
