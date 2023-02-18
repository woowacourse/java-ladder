package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

import static laddergame.view.message.Message.INPUT_LADDER_MAX_HEIGHT_GUIDE;
import static laddergame.view.message.Message.INPUT_PARTICIPANT_NAMES_GUIDE;

public class InputView {

    private final BufferedReader bufferedReader;

    public InputView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getParticipantNames() {
        OutputView.print(INPUT_PARTICIPANT_NAMES_GUIDE.getMessage());
        return readConsole();
    }

    public String getMaxLadderHeight() {
        OutputView.print(System.lineSeparator() + INPUT_LADDER_MAX_HEIGHT_GUIDE.getMessage());
        return readConsole();
    }

    public <T> T getInputWithRetry(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return getInputWithRetry(inputReader);
        }
    }

    private String readConsole() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            OutputView.print(e.getMessage());
        }
        return null;
    }
}
