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

    public String readParticipantNames() {
        OutputView.print(INPUT_PARTICIPANT_NAMES_GUIDE.getFormattedMessage());
        return readConsole();
    }

    public String readMaxLadderHeight() {
        OutputView.print(INPUT_LADDER_MAX_HEIGHT_GUIDE.getFormattedMessage());
        return readConsole();
    }

    public <T> T repeatUntilGettingValidValue(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return repeatUntilGettingValidValue(inputReader);
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
