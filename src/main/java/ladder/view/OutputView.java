package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {

    private OutputView() {}

    public static void printResult(Users users, Ladder ladder) {
        printUsersName(users);
        System.out.println();
        printLadder(ladder);
    }

    private static void printUsersName(Users users) {
        for (User user : users.getUsers()) {
            System.out.printf("%-7s", user.getName());
        }
    }

    private static void printLadder(Ladder ladder) {
        for (Floor floor : ladder.getFloors()) {
            printFloor(floor);
            System.out.println();
        }
    }

    private static void printFloor(Floor floor) {
        System.out.print("    ");
        System.out.print("|");
        for (Line line : floor.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        if (line.isExist()) {
            System.out.print("-----");
            System.out.print("|");
            return;
        }
        System.out.printf("     |");
    }

}
