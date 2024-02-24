package view;

import domain.Ladder;
import domain.Bridge;
import domain.Line;
import domain.UserName;
import domain.Users;
import java.util.List;

public class ResultView {

    private static final String LINE = "|-----";
    private static final String NONE_LINE = "|     ";

    private ResultView() {

    }

    public static void printNames(final Users users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%-6s", getFirst(users)));
        getMiddle(users).forEach(userName -> stringBuilder.append(String.format("%6s", userName)));
        stringBuilder.append(String.format("%5s", getLast(users)));

        System.out.println(stringBuilder);
    }

    private static List<UserName> getMiddle(Users users) {
        List<UserName> userNames = users.getUsers();
        return userNames.subList(1, userNames.size() - 1);
    }

    private static UserName getLast(Users users) {
        List<UserName> userNames = users.getUsers();
        return userNames.get(userNames.size()-1);
    }

    private static UserName getFirst(Users users) {
        List<UserName> userNames = users.getUsers();
        return userNames.get(0);
    }

    public static void printResultMessage() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printResult(final Ladder ladder) {
        for (Line line : ladder.getLadder()) {
            System.out.println(generateSingleLine(line));
        }
    }

    private static String generateSingleLine(final Line line) {
        return "    " + drawLine(line);
    }

    private static String drawLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Bridge bridge : line.getBridges()) {
            stringBuilder.append(drawBridge(bridge));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private static String drawBridge(final Bridge bridge) {
        if (bridge.getBridge()) {
            return LINE;
        }
        return NONE_LINE;
    }
}
