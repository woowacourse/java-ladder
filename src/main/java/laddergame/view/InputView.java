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

    public String readParticipantNames() {
        OutputView.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 분리하세요)");
        return readUserInput();
    }

    public String readMaxLadderHeight() {
        OutputView.print(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        return readUserInput();
    }

    public <T> T repeatUntilGettingValidValue(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return repeatUntilGettingValidValue(inputReader);
        }
    }

    private String readUserInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            OutputView.print(e.getMessage());
        }
        return null;
    }
}
