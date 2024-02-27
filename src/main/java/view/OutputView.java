package view;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import java.util.List;

public class OutputView {
    private final OutputFormatter outputFormatter;

    private OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public static OutputView from() {
        return new OutputView(new OutputFormatter());
    }

    public void printLadderMap(Players rawPlayers, Ladder ladder, List<String> prizes) {
        printLine("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printNames(Players players) {
        String nameUnit = outputFormatter.toNameUnit(players);
        printLine(nameUnit);
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLadderLine);
    }

    private void printPrizes(List<String> rawPrizes) {
        String prizes = outputFormatter.toPrize(rawPrizes);
        printLine(prizes);
    }

    private void printLadderLine(Line rawLine) {
        String line = outputFormatter.toLine(rawLine);
        printLine(line);
    }

    public void printGameResult(Players allPlayers) {
        System.out.println("실행 결과");
        allPlayers.getPlayers().forEach(player -> printLine("%s : %s", player.getName()));
    }

    public void printGameResult(Player player) {
    }

    public void printLine(String message) {
        System.out.println(message);
    }
    public void printLine(String message, Object... args) {
        System.out.printf(message, args);
        System.out.println();
    }
}
