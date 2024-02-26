package view;

import domain.*;

public class OutputView {
    private final OutputFormatter outputFormatter;

    public OutputView() {
        this.outputFormatter = new OutputFormatter();
    }

    public void printResult(Players rawPlayers, Ladder ladder, Targets targets) {
        System.out.println("실행결과");
        printNames(rawPlayers);
        printLadder(ladder);
        printTargets(targets);
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

    private void printTargets(Targets targets) {
        String targetUnit = outputFormatter.toTargetUnit(targets);
        System.out.println(targetUnit);
    }

    public void printPrize(Player player, Target target) {
        String result = outputFormatter.toResult(player, target);
        System.out.println(result);
    }
}
