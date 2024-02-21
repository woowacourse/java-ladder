package view;

import domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printResult(Players rawPlayers, Ladder ladder) {
        System.out.println("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line rawLine) {
        String line = rawLine.getPoints().stream()
                .map(this::getStep)
                .collect(Collectors.joining());
        System.out.println("    " + line);
    }

    private String getStep(Point point) {
        if (point.getStep().equals(Step.EXIST)) {
            return "|" + "-----";
        }
        return "|" + "     ";
    }

    private void printNames(Players rawPlayers) {
        List<Player> players = rawPlayers.getPlayers();
        StringBuilder nameUnit = new StringBuilder();
        for (Player player : players) {
            nameUnit.append(getNameUnit(player));
        }
        System.out.println(nameUnit);
    }

    private String getNameUnit(Player player) {
        String name = player.getName();
        if (name.length() < 5) {
            String leftBlank = " ".repeat(4 - name.length());
            String rightBalnk = " ";
            name = leftBlank + name + rightBalnk;
        }
        return name + " ";
    }
}
