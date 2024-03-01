package view;

import domain.ladder.Ladder;
import domain.ladder.Row;
import domain.player.Players;
import domain.result.GameResult;
import domain.prize.Prize;
import domain.prize.Prizes;

public class OutputView {
    private final OutputFormatter outputFormatter;

    private OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public static OutputView create() {
        return new OutputView(new OutputFormatter());
    }

    public void printLadderMap(final Players rawPlayers, final Ladder ladder, final Prizes prizes) {
        printLine("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printNames(final Players players) {
        final String nameUnit = outputFormatter.toNameUnit(players);
        printLine(nameUnit);
    }

    private void printLadder(final Ladder ladder) {
        ladder.getRows().forEach(this::printLadderRow);
    }

    private void printPrizes(final Prizes rawPrizes) {
        final String prizes = outputFormatter.toPrize(rawPrizes);
        printLine(prizes);
    }

    private void printLadderRow(final Row rawRow) {
        final String row = outputFormatter.toRow(rawRow);
        printLine(row);
    }

    public void printGameResult(final Prize prize) {
        printLine("실행 결과");
        printLine(prize.getPrize());
    }

    public void printGameResult(final GameResult playersWithPrize) {
        printLine("실행 결과");
        playersWithPrize.getPlayersPrize()
                .forEach((key, value) -> printLine("%s : %s", key.getName(), value.getPrize()));
    }

    public void printLine(final String message) {
        System.out.println(message);
    }

    public void printLine(final String message, final Object... args) {
        System.out.printf(message, args);
        System.out.println();
    }
}
