package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;

public class OutputView {

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
        List<Point> points = line.getPoints();
        StringBuilder result = new StringBuilder("    |");
        for (Point point : points) {
            result.append(point.toFormattedStatus());
        }
        System.out.println(result);
    }
}
