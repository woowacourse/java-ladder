package view;

import domain.Ladder;
import domain.Line;
import domain.Players;

public class OutputView {
    private final OutputFormatter outputFormatter;

    public OutputView() {
        this.outputFormatter = new OutputFormatter();
    }

    public void printResult(Players rawPlayers, Ladder ladder) {
        System.out.println("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
    }

    private void printNames(Players players) {
        String nameUnit = outputFormatter.toNameUnit(players);
        System.out.println(nameUnit);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line rawLine) {
        String line = outputFormatter.toLine(rawLine);
        System.out.println(line);
    }
}
