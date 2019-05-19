package ladderGame.view;

import ladderGame.constant.MessageContants;
import ladderGame.domain.*;

import java.util.List;

public class OutputView {
    public static void printLadder(GameData gameData, Ladder ladder) {
        printMember(gameData);
        printRowAndColumn(gameData, ladder);
        printGoal(gameData);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printResult(String name, String result) {
        System.out.println(name + " : " + result);
    }

    public static void printResultMessage() {
        System.out.println(MessageContants.MESSAGE_RESULT);
    }

    private static void printMember(GameData gameData) {
        for (Member member : gameData.getMembers()) {
            System.out.print(String.format(MessageContants.RESULT_FORMAT, member.getName()));
        }

        System.out.println();
    }

    private static void printGoal(GameData gameData) {
        for (Goal goal : gameData.getGoals()) {
            System.out.printf(String.format(MessageContants.RESULT_FORMAT, goal.getPlayResult()));
        }

        System.out.println();
    }

    private static void printRowAndColumn(GameData gameData, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print(MessageContants.MESSAGE_INDENT + MessageContants.MESSAGE_COLUMN);
            printColumn(gameData.getMembers(), line);
            System.out.println();
        }
    }

    private static void printColumn(List<Member> members, Line line) {
        for (int i = 0; i < members.size() - 1; i++) {
            printRow(line, i);
            System.out.print(MessageContants.MESSAGE_COLUMN);
        }
    }

    private static void printRow(Line line, int index) {
        if (line.isConnected(index)) {
            System.out.print(MessageContants.MESSAGE_ROW);
        }
        if (!line.isConnected(index)) {
            System.out.print(MessageContants.MESSAGE_BLANK);
        }
    }
}