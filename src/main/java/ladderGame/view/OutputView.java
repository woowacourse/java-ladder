package ladderGame.view;

import java.util.List;
import java.util.Map;

import ladderGame.domain.*;

public class OutputView {
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
            System.out.print("|");
            printPoint(point.isHasRight());
        }
    }

    private static void printPoint(boolean isStair) {
        if (isStair) {
            System.out.print("-----");
        }
        if (!isStair) {
            System.out.print("     ");
        }
    }

    public static void printResults(List<String> results) {
        for (String result : results) {
            System.out.printf("%-6s", result);
        }
        System.out.println();
    }

    public static void printResult(Reward result) {
        System.out.println(result);
    }

    public static void printLadderUI(List<User> users, Ladder ladder, List<String> results) {
        printNames(users);
        printLadder(ladder.getFloors());
        printResults(results);
    }

    public static void printResultAll(Map<UserName, Reward> resultMap) {
        for (UserName userName : resultMap.keySet()) {
            Reward value = resultMap.get(userName);
            System.out.println(userName + " : " + value);
        }
    }
}
