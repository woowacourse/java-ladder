package view;

import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;

public class OutputView {

    private static final String POINT = "-----|";
    private static final String BLANK = "     |";

    public void printNames(Players players) {
        players.getPlayers().stream()
                .map(Player::getName)
                .forEach(this::printName);
    }

    private void printName(String name) {
        int length = name.length();
        String result = " ".repeat(5 - length);
        result += name;
        System.out.print(result);
    }

    public void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(this::printLine);
    }

    private void printLine(Line line) {
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
