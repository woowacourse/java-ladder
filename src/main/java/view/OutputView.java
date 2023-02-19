package view;

import domain.Ladder;
import domain.Line;
import domain.LinePoint;
import domain.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String EDGE_OF_POINT = "|";
    private static final String PASSABLE_POINT = "-----";
    private static final String BLOCKED_POINT = "     ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printResult(Players players,
                            Ladder ladder) {
        System.out.println("실행결과");

        System.out.println(getFormattedNames(players));
        printLadder(ladder);
    }

    private String getFormattedNames(Players players) {
        return players.getPlayers().stream()
                .map(player -> String.format("%-5s", player.getName()))
                .collect(Collectors.joining(" "));
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        line.getPoints().forEach(this::printPoint);
        System.out.println(EDGE_OF_POINT);
    }

    private void printPoint(LinePoint point) {
        if (point.isPassable()) {
            System.out.print(EDGE_OF_POINT + PASSABLE_POINT);
            return;
        }
        System.out.print(EDGE_OF_POINT + BLOCKED_POINT);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}
