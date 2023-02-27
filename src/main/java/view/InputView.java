package view;

import java.util.List;
import java.util.Scanner;
import view.constant.Command;
import view.constant.Sign;

public class InputView {

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String POSITIVE_INTEGER_ERROR_MESSAGE = "정수를 입력해주세요.";
    private static final String NOT_MATCH_WITH_PLAYER_LENGTH = "참가자 수 와 결과가 맞지 않습니다.";
    private static final String SEPARATOR_REQUIRED_ERROR_MESSAGE = Sign.COMMA.getShape() + "로 이름을 구분해주세요";
    public static final String CONTAIN_RESERVATION_WORD = "\n예약어는 사용하실 수 없습니다.\n";
    private static final String REQUEST_RESULT_MESSAGE = "\n결과를 보고 싶은 사람은?\n(all=모두, end=종료)\n";
    private static final String REQUEST_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 %s(%s)로 구분하세요)%n";
    private static final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 %s(%s)로 구분하세요)%n";
    private static final Scanner scanner = new Scanner(System.in);


    public static List<String> getNames() {
        printWithDelimiter(REQUEST_NAME_MESSAGE);
        List<String> names = getInputs();
        validateInputWord(names);
        return names;
    }

    private static List<String> getInputs() {
        String input = input();
        validateSeparatorShape(input);
        return getSeparated(input);
    }

    public static int getHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT_MESSAGE);
        int input;
        try {
            input = Integer.parseInt(input());
            validatePositiveInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE);
        }
        return input;
    }

    public static List<String> getPrizes(final int count) {
        printWithDelimiter(REQUEST_PRIZE_MESSAGE);
        List<String> prizes = getInputs();
        validateInputWord(prizes);
        validatePrizesLength(count, prizes.size());
        return prizes;
    }

    private static void printWithDelimiter(final String message) {
        System.out.printf(message, Sign.COMMA.getKorean(), Sign.COMMA.getShape());
    }

    private static void validateInputWord(final List<String> input) {
        for (String doubtWord : input) {
            validateReservedWord(doubtWord);
        }
    }

    private static void validateReservedWord(final String input) {
        if (!Command.isCommand(input)) {
            throw new IllegalArgumentException(CONTAIN_RESERVATION_WORD);
        }
    }

    private static void validatePrizesLength(final int targetCount, final int inputCount) {
        if (targetCount != inputCount) {
            throw new IllegalArgumentException(NOT_MATCH_WITH_PLAYER_LENGTH);
        }
    }

    private static void validatePositiveInteger(final int input) {
        if (input < 1) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE);
        }
    }

    private static List<String> getSeparated(final String input) {
        return List.of(removeSpace(input).split(Sign.COMMA.getShape()));
    }

    private static String removeSpace(final String input) {
        return input.replace(SPACE, BLANK);
    }

    private static String input() {
        return scanner.nextLine();
    }

    private static void validateSeparatorShape(final String input) {
        if (!input.contains(Sign.COMMA.getShape())) {
            throw new IllegalArgumentException(SEPARATOR_REQUIRED_ERROR_MESSAGE);
        }
    }

    public static String getPlayerResult() {
        System.out.printf(REQUEST_RESULT_MESSAGE);
        return input();
    }
}
