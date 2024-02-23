package view;

import domain.Line;
import domain.Player;
import domain.Players;
import domain.Step;
import java.util.stream.Collectors;

public class OutputFormatter {
    private static final String SPACE = " ";
    private static final String BAR = "|";

    public String toNameUnit(Players players) {
        return players.getPlayers().stream()
                .map(this::getNameUnit)
                .collect(Collectors.joining());
    }

    public String toLine(Line rawLine) {
        String line = rawLine.getPoints().stream()
                .map(this::getStep)
                .collect(Collectors.joining());
        return "    " + line;
    }

    private String getNameUnit(Player player) {
        String name = player.getName();
        if (name.length() < 5) {
            String leftBlank = SPACE.repeat(4 - name.length());
            name = leftBlank + name + SPACE;
        }
        return name + SPACE;
    }

    private String getStep(Step step) {
        if (step.isExist()) {
            return BAR + "-----";
        }
        return BAR + "     ";
    }
}
