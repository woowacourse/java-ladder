package view;

import java.util.List;

import domain.Floor;
import domain.User;

public class OutputView {
    public static void outputNames(List<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    public static void outputLadder(List<Floor> ladder) {
        for (Floor floor : ladder) {
            outputFloor(floor);
            System.out.println("|");
        }
    }

    private static void outputFloor(Floor floor) {
        for (boolean isStair : floor.getStairs()) {
            System.out.print("|");
            outputStair(isStair);
        }
    }

    private static void outputStair(boolean isStair) {
        if (isStair) {
            System.out.print("-----");
        }
        if (!isStair) {
            System.out.print("     ");
        }
    }

    public static void outputResult(List<String> results) {
        for (String result : results) {
            System.out.printf("%-6s", result);
        }
    }

}
