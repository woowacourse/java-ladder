package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String STOOL_EMPTY = "     ";
    private static final String STOOL_EXIST = "-----";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLadder(List<String> names, List<List<Boolean>> ladder, List<String> prizes) {
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

    private void printStoolsOnEachLevel(List<List<Boolean>> ladder) {
        ladder.stream()
                .map(this::makeLevelView)
                .forEach(System.out::println);
    }

    private String makeLevelView(List<Boolean> level) {
        return "    |" + level.stream()
                .map(this::makeStoolView)
                .collect(Collectors.joining("|")) + "|";
    }

    private String makeStoolView(boolean stool) {
        if (stool)
            return STOOL_EXIST;

        return STOOL_EMPTY;
    }

    private void printPrizes(List<String> results) {
        results.stream()
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
