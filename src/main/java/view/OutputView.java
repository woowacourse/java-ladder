package view;

import domain.*;

import java.util.List;

public class OutputView {
    private final OutputFormatter outputFormatter;

    public OutputView() {
        this.outputFormatter = new OutputFormatter();
    }

    public void printResult(Players rawPlayers, Ladder ladder, Targets targets) {
        System.out.println("사다리 결과");
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

    public void printPrize(Target target) {
        System.out.println("실행 결과");
        System.out.println(target.getTarget());
    }

    public void printAllPrize(List<Player> players, List<Target> targets) {
        System.out.println("실행 결과");
        for (int i = 0; i < players.size(); i++) {
            String result = outputFormatter.toResult(players.get(i), targets.get(i));
            System.out.println(result);
        }
    }
}
