package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class InputView {

    private final BufferedReader bufferedReader;

    public InputView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readConsole() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            OutputView.print(e.getMessage());
        }
        return null;
    }

    public <T> T getInputWithRetry(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return getInputWithRetry(inputReader);
        }
    }
}
