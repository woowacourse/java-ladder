package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.regex.Pattern;

public class OutputView {

    private OutputView() {}

    public static void printResult(Users users, Ladder ladder) {
        printUsersName(users);
        System.out.println();
        printLadder(ladder);
    }

    private static void printUsersName(Users users) {
        for (User user : users.getUsers()) {
            System.out.printf(" ".repeat(10 - calculateBlank(user)));
            System.out.printf("%s", user.getName());
        }
    }

    private static int calculateBlank(User user) {
        double userNameSpan = 0.0;
        for(Character name : user.getName().toCharArray()){
            userNameSpan+=userNameSpanSize(name);
        }
        return (int)(userNameSpan+0.5);
    }

    private static double userNameSpanSize(Character name) {
        String hi = String.valueOf(name);
        if(Pattern.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]", hi)){
            return 1.5;
        }
        return 1.0;
    }


    private static void printLadder(Ladder ladder) {
        for (Floor floor : ladder.getFloors()) {
            printFloor(floor);
            System.out.println();
        }
    }

    private static void printFloor(Floor floor) {
        System.out.print(" ".repeat(9));
        System.out.print("|");
        for (Line line : floor.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        if (line.isExist()) {
            System.out.print("-".repeat(9));
            System.out.print("|");
            return;
        }
        System.out.printf("         |");
    }

}
