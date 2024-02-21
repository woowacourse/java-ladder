package view;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import java.util.List;

public class OutputView {

    private static final String RESULT = "실행결과\n";
    private static final String STICK = "|";
    private static final String LEG_UNIT = "-";
    private static final String FORMAT_NAME = "%6s";

    public static void printResult(Players players, Ladder ladder) {
        System.out.println(RESULT);
        printPlayers(players.getPlayers());

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printPrefixSpace(players.getPlayers());
            printLine(line.getLegs());
        }
    }

    private static void printPlayers(List<Player> players) {
        System.out.print(players.get(0).getName() + " ");
        for (int i = 1; i < players.size(); i++) {
            System.out.printf(FORMAT_NAME, players.get(i).getName());
        }
        System.out.println();
    }

    private static void printPrefixSpace(List<Player> players) {
        System.out.print(" ".repeat(getFirstPlayerNameSize(players)));
    }

    private static int getFirstPlayerNameSize(List<Player> players) {
        return players.get(0).getName().length();
    }

    private static void printLine(List<Boolean> legs) {
        for (Boolean leg : legs) {
            System.out.print(STICK);
            System.out.print(extractLeg(leg));
        }
        System.out.print(STICK + "\n");
    }

    private static String extractLeg(boolean isExistLeg) {
        if (isExistLeg) {
            return LEG_UNIT.repeat(5);
        }
        return " ".repeat(5);
    }

}
