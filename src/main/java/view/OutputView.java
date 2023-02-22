package view;

import domain.Goals;
import domain.Names;
import domain.ladder.Ladder;
import util.MessageGenerator;
import util.MessagePrinter;
import view.constant.Sign;

import java.util.List;

public class OutputView {

    public static final String REQUEST_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)";
    public static final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_MESSAGE = "실행결과";
    public static final String REQUIRING_GOALS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String REQUIRING_NAME_TO_INQUIRE = "결과를 보고 싶은 사람은?";

    private final MessagePrinter messagePrinter;

    public OutputView(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public void printRequestNames() {
        messagePrinter.println(String.format(REQUEST_NAME_MESSAGE, Sign.COMMA.getKorean(), Sign.COMMA.getShape()));
    }

    public void printRequestLadderHeight() {
        messagePrinter.println(REQUEST_LADDER_HEIGHT_MESSAGE);
    }

    public void printLadder(final Names names, final Ladder ladder, Goals goals) {
        printResultMessage();
        printParticipantNames(names);
        printGeneratedLadder(ladder.getConnectedToRightConditionsOfAll());
        printGoals(goals);
    }

    private void printGoals(Goals goals) {
        messagePrinter.println(MessageGenerator.generateGoalsMessage(goals));
    }

    private void printResultMessage() {
        messagePrinter.println(RESULT_MESSAGE);
    }

    private void printParticipantNames(final Names names) {
        messagePrinter.println(MessageGenerator.generateNamesMessage(names));
    }

    private void printGeneratedLadder(final List<List<Boolean>> ladderInfo) {
        List<String> ladderMessages = MessageGenerator.generateLadderMessage(ladderInfo);
        for (String ladderMessage : ladderMessages) {
            messagePrinter.println(ladderMessage);
        }
    }

    public void printErrorMessage(final String errorMessage) {
        messagePrinter.println(errorMessage);
    }

    public void printRequestGoals() {
        messagePrinter.println(REQUIRING_GOALS_MESSAGE);
    }

    public void printRequestNameToRide() {
        messagePrinter.println(REQUIRING_NAME_TO_INQUIRE);
    }

    public void printResult(String participantName, String goalName) {
        messagePrinter.println(String.format("%s : %s", participantName, goalName));
    }
}
