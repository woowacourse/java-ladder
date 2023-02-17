package ladder.view;

import ladder.domain.*;

import java.util.regex.Pattern;

public class OutputView {

    private static final String BLANK_SPACE = " ";
    private static final int ONE_BLOCK_SIZE = 10;
    private static final double INIT_SPAN = 0.0;
    private static final String KOREAN_MATCH_REGEX = "[ㄱ-ㅎㅏ-ㅣ가-힣]";
    private static final double KOREAN_SPAN = 1.5;
    private static final double OTHER_SPAN = 1.0;
    private static final String DELIMITER = "|";
    private static final String LINE_COMPONENT = "-";
    private static final int BLOCK_SIZE_EXCEPT_DELIMITER = 9;

    private OutputView() {
    }

    public static void printResult(Users users, Ladder ladder) {

        printUsersName(users);
        System.out.println();
        printLadder(ladder);
    }

    private static void printUsersName(Users users) {

        for (User user : users.getUsers()) {
            System.out.print(BLANK_SPACE.repeat(ONE_BLOCK_SIZE - calculateBlank(user)));
            System.out.printf("%s", user.getName());
        }
    }

    private static int calculateBlank(User user) {

        double userNameSpan = INIT_SPAN;
        for (Character name : user.getName().toCharArray()) {
            userNameSpan += userNameSpanSize(name);
        }
        return (int) Math.round(userNameSpan);
    }

    private static double userNameSpanSize(Character name) {

        String hi = String.valueOf(name);

        if (Pattern.matches(KOREAN_MATCH_REGEX, hi)) {
            return KOREAN_SPAN;
        }
        return OTHER_SPAN;
    }

    private static void printLadder(Ladder ladder) {

        for (Floor floor : ladder.getFloors()) {
            printFloor(floor);
            System.out.println();
        }
    }

    private static void printFloor(Floor floor) {

        System.out.print(BLANK_SPACE.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(DELIMITER);
        for (Boolean line : floor.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Boolean line) {

        if (line) {
            System.out.print(LINE_COMPONENT.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
            System.out.print(DELIMITER);
            return;
        }
        System.out.print(BLANK_SPACE.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(DELIMITER);
    }

}
