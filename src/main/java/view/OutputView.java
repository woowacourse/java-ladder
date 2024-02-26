package view;

import domain.Ladder;
import domain.Line;
import java.util.List;
import view.printer.Printer;

public class OutputView {
    private final Printer printer;
    private final OutputFormatter outputFormatter;

    private OutputView(Printer printer, OutputFormatter outputFormatter) {
        this.printer = printer;
        this.outputFormatter = outputFormatter;
    }

    public static OutputView from(Printer printer) {
        return new OutputView(printer, new OutputFormatter());
    }

    public void printResult(List<String> rawPlayers, Ladder ladder) {
        printer.printLine("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
    }

    private void printNames(List<String> players) {
        String nameUnit = outputFormatter.toNameUnit(players);
        printer.printLine(nameUnit);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line rawLine) {
        String line = outputFormatter.toLine(rawLine);
        printer.printLine(line);
    }
}
