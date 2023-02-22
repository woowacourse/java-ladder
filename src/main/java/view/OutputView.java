package view;

import domain.Ladder;
import domain.Level;
import domain.Stool;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String STOOL_EMPTY = "     ";
    private static final String STOOL_EXIST = "-----";
    private static final String COLUMN = "|";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLadder(List<String> names, Ladder ladder, List<String> prizes) {
        System.out.println("\n사다리 결과\n");
        printNames(names);
        printStoolsOnEachLevel(ladder);
        printPrizes(prizes);
    }

    private void printNames(List<String> names) {
        names.stream()
                .map(name -> String.format("%6s", name))
                .forEach(System.out::print);

        System.out.println();
    }

    private void printStoolsOnEachLevel(Ladder ladder) {
        ladder.getLevels().stream()
                .map(this::makeLevelView)
                .forEach(System.out::println);
    }

    private String makeLevelView(Level level) {
        String stoolsView = level.getStools().stream()
                .map(this::makeStoolView)
                .collect(Collectors.joining(COLUMN));

        return "    " + COLUMN + stoolsView + COLUMN;
    }

    private String makeStoolView(Stool stool) {
        if (stool.isExist()) {
            return STOOL_EXIST;
        }

        return STOOL_EMPTY;
    }

    private void printPrizes(List<String> prizes) {
        prizes.stream()
                .map(result -> String.format("%6s", result))
                .forEach(System.out::print);

        System.out.println();
    }

    public void printResult(String prize) {
        System.out.println("\n실행 결과");
        System.out.println(prize);
    }

    public void printAllResults(List<String> names, List<String> prizes) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + prizes.get(i));
        }
    }
}
