package view;

import domain.Ladder;
import domain.Line;
import java.util.List;

public class OutputView {
    private final OutputFormatter outputFormatter;

    private OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public static OutputView from() {
        return new OutputView(new OutputFormatter());
    }

    public void printResult(List<String> rawPlayers, Ladder ladder) {
        printLine("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
    }

    private void printNames(List<String> players) {
        String nameUnit = outputFormatter.toNameUnit(players);
        printLine(nameUnit);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLadderLine);
    }

    private void printLadderLine(Line rawLine) {
        String line = outputFormatter.toLine(rawLine);
        printLine(line);
    }

    public void printLine(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
