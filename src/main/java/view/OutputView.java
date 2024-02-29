package view;

import domain.ladder.Ladder;
import domain.ladder.Row;
import domain.player.Players;
import domain.result.PlayersPrize;
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

    public void printLadderMap(Players rawPlayers, Ladder ladder, Prizes prizes) {
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
        ladder.getRows().forEach(this::printLadderRow);
    }

    private void printPrizes(Prizes rawPrizes) {
        String prizes = outputFormatter.toPrize(rawPrizes);
        printLine(prizes);
    }

    private void printLadderRow(Row rawRow) {
        String row = outputFormatter.toRow(rawRow);
        printLine(row);
    }

    public void printGameResult(Prize prize) {
        printLine("실행 결과");
        printLine(prize.getPrize());
    }

    public void printGameResult(PlayersPrize playersWithPrize) {
        printLine("실행 결과");
        playersWithPrize.getPlayersPrize().forEach((key, value) -> printLine("%s : %s", key.getName(), value.getPrize()));
    }
    public void printLine(String message) {
        System.out.println(message);
    }

    public void printLine(String message, Object... args) {
        System.out.printf(message, args);
        System.out.println();
    }
}
