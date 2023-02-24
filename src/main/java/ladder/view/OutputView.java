package ladder.view;

import ladder.domain.*;

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

    public static void printLadder(Users users, Ladder ladder, Prizes prizes) {
        printUsersName(users);
        System.out.println();
        printLadder(ladder);
        printPrizes(prizes);
    }

    private static void printPrizes(Prizes prizes) {
        prizes.getPrizeNames().forEach(prize -> System.out.printf("%10s", prize));
        System.out.println();
    }

    private static void printUsersName(Users users) {
        for (User user : users.getUsers()) {
            System.out.print(BLANK_SPACE.repeat(ONE_BLOCK_SIZE - calculateBlank(user)));
            System.out.printf("%s", user.getName().getValue());
        }
    }

    private static int calculateBlank(User user) {
        double userNameSpan = INIT_SPAN;
        for (Character name : user.getName().getValue().toCharArray()) {
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
        for (Point point : floor.getPoints()) {
            printLine(point);
        }
    }

    private static void printLine(Point point) {
        if (point.isExist()) {
            System.out.print(LINE_COMPONENT.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
            System.out.print(DELIMITER);
            return;
        }
        System.out.print(BLANK_SPACE.repeat(BLOCK_SIZE_EXCEPT_DELIMITER));
        System.out.print(DELIMITER);
    }

    public static void printSingleResult(PrizeName prizeName) {
        System.out.println("실행 결과");
        if (prizeName == null) {
            System.out.println("없는 유저 이름입니다.");
            return;
        }
        System.out.println(prizeName.getValue());
        System.out.println();
    }

    public static void printAll(Map<UserName, PrizeName> allResult) {
        System.out.println("실행 결과");
        allResult.forEach((userName, prizeName) -> System.out.println(userName.getValue() + " : " + prizeName.getValue()));
    }
}
