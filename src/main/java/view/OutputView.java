package view;

import domain.*;

import java.util.List;

public class OutputView {

    private static final String RESULT = "\n실행결과\n";
    private static final String STICK = "|";
    private static final String LEG_UNIT = "-";
    private static final String FORMAT_NAME = "%6s";

    public static void printResult(Players players, Ladder ladder) {
        System.out.println(RESULT);
        List<Player> gamePlayers = players.getPlayers();
        printPlayers(gamePlayers);

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printPrefixSpace(gamePlayers);
            printLine(line.getLegs());
        }
    }

    private static void printPlayers(List<Player> players) {
        System.out.print(players.get(0).getName() + " ");
        players.stream()
                .skip(1)
                .forEach(player -> System.out.printf(FORMAT_NAME, player.getName()));
        System.out.println();
    }

    private static void printPrefixSpace(List<Player> players) {
        System.out.print(" ".repeat(getFirstPlayerNameSize(players)));
    }

    private static int getFirstPlayerNameSize(List<Player> players) {
        return players.get(0).getName().length();
    }

    private static void printLine(List<Leg> legs) {
        for (Leg leg : legs) {
            System.out.print(STICK);
            System.out.print(extractLeg(leg.isExist()));
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
