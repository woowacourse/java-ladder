package view;

import exception.EmpytInputException;
import exception.InvalidLadderCountException;
import exception.InvalidLadderHeightException;
import exception.InvalidParticipantsCountException;
import exception.InvalidPersonNameException;
import exception.NameContainsIdentifierException;
import java.util.Scanner;
import validate.ErrorMessage;

public class InputView {

    private static final String ENTER_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ENTER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner = new Scanner(System.in);

    private String readLine() {
        return scanner.nextLine();
    }

    public String enterParticipantsNameUntilValid() {
        try {
            return enterParticipantsName();
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return enterParticipantsNameUntilValid();
        }
    }

    private String enterParticipantsName() {
        System.out.println(ENTER_PARTICIPANTS_NAME);
        return readLine();
    }

    public String enterHeightUntilValid() {
        try {
            return enterHeight();
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return enterHeightUntilValid();
        }
    }

    private String enterHeight() {
        System.out.println(ENTER_HEIGHT);
        return readLine();
    }

    private void printErrorMessage(IllegalArgumentException exception) {
        if (exception instanceof EmpytInputException) {
            System.out.println(ErrorMessage.EMPTY_INPUT.getMessage());
        }
        if (exception instanceof InvalidLadderCountException) {
            System.out.println(ErrorMessage.INVALID_LADDER_COUNT.getMessage());
        }
        if (exception instanceof InvalidLadderHeightException) {
            System.out.println(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
        }
        if (exception instanceof InvalidParticipantsCountException) {
            System.out.println(ErrorMessage.INVALID_PARTICIPANT_COUNT.getMessage());
        }
        if (exception instanceof InvalidPersonNameException) {
            System.out.println(ErrorMessage.INVALID_PERSON_NAME.getMessage());
        }
        if (exception instanceof NameContainsIdentifierException) {
            System.out.println(ErrorMessage.CONTAINS_DUPLICATE_IDENTIFIER.getMessage());
        }
    }

}
