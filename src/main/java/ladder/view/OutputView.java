package ladder.view;

import ladder.domain.*;
import ladder.dto.BridgeGameResultDto;

import java.util.Map;
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

    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println("사다리 결과");
        printUsersName(ladderGame.getUsers());
        printLadder(ladderGame.getLadder());
        printReward(ladderGame.getReward());
    }

    private static void printReward(final Reward rewards) {
        for (String reward : rewards.getRewardItemsName()) {
            printFormatted(reward);
        }
        System.out.println();
    }

    private static void printUsersName(Users users) {
        for (User user : users.getUsers()) {
            printFormatted(user.getName());
        }
        System.out.println();
    }

    private static void printFormatted(final String value) {
        System.out.print(BLANK_SPACE.repeat(ONE_BLOCK_SIZE - calculateSizeOf(value)));
        System.out.printf("%s", value);
    }

    private static int calculateSizeOf(String data) {
        double userNameSpan = INIT_SPAN;
        for (Character word : data.toCharArray()) {
            userNameSpan += userNameSpanSize(word);
        }
        return (int) (userNameSpan);
    }

    private static double userNameSpanSize(Character word) {
        String value = String.valueOf(word);
        if (Pattern.matches(KOREAN_MATCH_REGEX, value)) {
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
        for (Line line : floor.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        if (line.isExist()) {
            System.out.print(LINE_COMPONENT.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
            System.out.print(DELIMITER);
            return;
        }
        System.out.print(BLANK_SPACE.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(DELIMITER);
    }

    public static void printReward(String reward) {
        System.out.println("실행 결과");
        System.out.println(reward);
        System.out.println();
    }

    public static void printResult(BridgeGameResultDto result) {
        final Map<String, String> userAndReward = result.getUserAndReward();
        for (String user : userAndReward.keySet()) {
            printUserReward(user, userAndReward);
        }
    }

    private static void printUserReward(final String user, final Map<String, String> userAndReward) {
        System.out.println(user + " : " + userAndReward.get(user));
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] : " + message);
    }
}
