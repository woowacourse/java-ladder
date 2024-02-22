package view;

import domain.Line;
import domain.Player;
import domain.Players;
import domain.Point;
import domain.Step;
import java.util.stream.Collectors;

public class OutputFormatter {
    public String toLine(Line rawLine) {
        String line = rawLine.getPoints().stream()
                .map(this::getStep)
                .collect(Collectors.joining());
        return "    " + line;
    }

    private String getStep(Point point) {
        if (point.getStep().equals(Step.EXIST)) {
            return "|" + "-----";
        }
        return "|" + "     ";
    }

    public String toNameUnit(Players players) {
        return players.getPlayers().stream()
                .map(this::getNameUnit)
                .collect(Collectors.joining());
    }

    private String getNameUnit(Player player) {
        String name = player.getName();
        if (name.length() < 5) {
            String leftBlank = " ".repeat(4 - name.length());
            String rightBlank = " ";
            name = leftBlank + name + rightBlank;
        }
        return name + " ";
    }
}
