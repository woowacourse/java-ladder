package ladderGame.view;

import java.util.List;
import java.util.Map;

import ladderGame.domain.*;

public class OutputView {
    private static final String LINE = "|";
    private static final String STAIR = "-----";
    private static final String STAIR_NONE = "     ";
    private static final String RESULT_DELIMITER = " : ";

    public static void printNames(List<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    public static void printLadder(List<Floor> ladder) {
        for (Floor floor : ladder) {
            printFloor(floor);
            System.out.println();
        }
    }

    private static void printFloor(Floor floor) {
        for (Point point : floor.getPoints()) {
            System.out.print(LINE);
            printPoint(point.isHasRight());
        }
    }

    private static void printPoint(boolean isStair) {
        if (isStair) {
            System.out.print(STAIR);
        }
        if (!isStair) {
            System.out.print(STAIR_NONE);
        }
    }

    public static void printResults(List<Reward> rewards) {
        for (Reward reward : rewards) {
            System.out.printf("%-6s", reward);
        }
        System.out.println();
    }

    public static void printResult(Reward result) {
        System.out.println(result);
    }

    public static void printLadderUI(List<User> users, Ladder ladder, List<Reward> rewards) {
        printNames(users);
        printLadder(ladder.getFloors());
        printResults(rewards);
    }

    public static void printResultAll(Map<UserName, Reward> resultMap) {
        for (UserName userName : resultMap.keySet()) {
            Reward value = resultMap.get(userName);
            System.out.println(userName + RESULT_DELIMITER + value);
        }
    }
}
