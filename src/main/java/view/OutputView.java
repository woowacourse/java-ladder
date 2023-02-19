package view;

import domain.Ladder;
import domain.Names;
import util.MessageGenerator;
import util.MessagePrinter;
import view.constant.Sign;

import java.util.List;

public class OutputView {

    public static final String REQUEST_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n";
    public static final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_MESSAGE = "실행결과";

    private final MessagePrinter messagePrinter;

    public OutputView(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void printRequestNames() {
        messagePrinter.print(String.format(REQUEST_NAME_MESSAGE, Sign.COMMA.getKorean(), Sign.COMMA.getShape()));
    }

    public void printRequestLadderHeight() {
        messagePrinter.println(REQUEST_LADDER_HEIGHT_MESSAGE);
    }

    public void printResult(final Names names, final Ladder ladder) {
        printResultMessage();
        printParticipantNames(names);
        printGeneratedLadder(ladder.getValue(), names.findMaxNameLength());
    }

    private void printResultMessage() {
        messagePrinter.println(RESULT_MESSAGE);
    }

    private void printParticipantNames(final Names names) {
        messagePrinter.println(MessageGenerator.generateNamesMessage(names));
    }

    private void printGeneratedLadder(final List<List<Boolean>> ladderInfo, final int maxNameLength) {
        List<String> ladderMessages = MessageGenerator.generateLadderMessage(ladderInfo, maxNameLength);
        for (String ladderMessage : ladderMessages) {
            messagePrinter.println(ladderMessage);
        }
    }

    public void printErrorMessage(final String errorMessage) {
        messagePrinter.println(errorMessage);
    }
}
