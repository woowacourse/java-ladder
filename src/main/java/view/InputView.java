package view;

import exception.view.EmptyInputException;
import java.util.Scanner;

public class InputView {

    private static final String ENTER_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_HEIGHT = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final String ENTER_LADDER_RESULT = System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ENTER_NAME_FOR_RESULT = System.lineSeparator() + "결과를 보고 싶은 사람은? ( 종료는 exit 입니다. )";
    private final Scanner scanner = new Scanner(System.in);

    private String readLine() {
        return scanner.nextLine();
    }

    public String enterParticipantsName() {
        try {
            System.out.println(ENTER_PARTICIPANTS_NAME);
            String participantNames = readLine();
            validate(participantNames);
            return participantNames;
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return enterParticipantsName();
        }
    }

    public String enterHeight() {
        try {
            System.out.println(ENTER_HEIGHT);
            String height = readLine();
            validate(height);
            return height;
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return enterHeight();
        }
    }

    public String enterLadderResult() {
        try {
            System.out.println(ENTER_LADDER_RESULT);
            String ladderResult = readLine();
            validate(ladderResult);
            return ladderResult;
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return enterLadderResult();
        }
    }

    public String enterNameForResult() {
        try {
            System.out.println(ENTER_NAME_FOR_RESULT);
            String nameForResult = readLine();
            validate(nameForResult);
            return nameForResult;
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return enterNameForResult();
        }
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new EmptyInputException();
        }
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
