package view;

import domain.Ladder;
import domain.Names;
import util.MessageGenerator;
import view.constant.Sign;

import java.util.List;

public class OutputView {

    public static final String REQUEST_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n";
    public static final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT_MESSAGE = "실행결과";

    public static void printRequestNames() {
        System.out.printf(REQUEST_NAME_MESSAGE, Sign.COMMA.getKorean(), Sign.COMMA.getShape());
    }

    public static void printRequestLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT_MESSAGE);
    }

    public static void printResult(final Names names, final Ladder ladder) {
        printResultMessage();
        printParticipantNames(names);
        printGeneratedLadder(ladder.getValue(), names.findMaxNameLength());
    }

    private static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static void printParticipantNames(final Names names) {
        System.out.println(MessageGenerator.generateNamesMessage(names));
    }

    private static void printGeneratedLadder(final List<List<Boolean>> ladderInfo, final int maxNameLength) {
        List<String> ladderMessages = MessageGenerator.generateLadderMessage(ladderInfo, maxNameLength);
        for (String ladderMessage : ladderMessages) {
            System.out.println(ladderMessage);
        }
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
