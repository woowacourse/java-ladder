package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;

public class OutputView {

    private static final String POINT = "-----|";
    private static final String BLANK = "     |";

    public static void printNames(Players players) {
        players.getPlayers().stream()
                .map(Player::getName)
                .forEach(OutputView::printName);
        System.out.println();
    }

    private static void printName(String name) {
        int length = name.length();
        String result = " ".repeat(7 - length);
        result += name;
        System.out.print(result);
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        List<Boolean> points = line.getPoints();
        String result = "    |";
        for (Boolean point : points) {
            if (point) {
                result += POINT;
                continue;
            }
            result += BLANK;
        }
        System.out.println(result);
    }
}
