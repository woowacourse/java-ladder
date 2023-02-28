package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class InputView {

    private static final String NEW_LINE = System.lineSeparator();

    private final BufferedReader bufferedReader;

    public InputView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readParticipantNames() {
        return readUserInputAfterPrintMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 분리하세요)");
    }

    public String readMaxLadderHeight() {
        return readUserInputAfterPrintMessage(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
    }

    public String readResults() {
        return readUserInputAfterPrintMessage(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public String readRequest() {
        return readUserInputAfterPrintMessage(NEW_LINE + "결과를 보고 싶은 사람은?");
    }

    public <T> T repeatUntilGettingValidValue(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return repeatUntilGettingValidValue(inputReader);
        }
    }

    private String readUserInputAfterPrintMessage(final String guideMessage) {
        try {
            OutputView.print(guideMessage);
            return bufferedReader.readLine();
        } catch (IOException e) {
            OutputView.print(e.getMessage());
        }
        return null;
    }
}
