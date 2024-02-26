package view;

import domain.Bridge;
import domain.Bridges;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prize;
import domain.Prizes;
import domain.Result;
import domain.Results;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNames(Names names) {
        for (Name name : names.getNames()) {
            System.out.printf("%5s ", name.getValue());
        }
        System.out.println();
    }

    public static void printPrizes(Prizes prizes) {
        for (Prize prize : prizes.getPrizes()) {
            System.out.printf("%5s ", prize.getValue());
        }
        System.out.println();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<Bridges> bridge = ladder.getBridge();
        for (Bridges bridges : bridge) {
            String line = bridges.getBridges()
                    .stream()
                    .map(OutputView::getBridgeMessage)
                    .collect(Collectors.joining("|"));
            System.out.printf("    |%s|\n", line);
        }
    }

    private static String getBridgeMessage(Bridge bridge) {
        if (bridge == Bridge.BUILT) {
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printResults(Results results) {
        List<Result> results1 = results.getResults();

        System.out.println("실행 결과");
        results1.forEach((result) -> {
            System.out.printf("%s : %s\n", result.getName().getValue(), result.getPrize());
        });
    }

    public static void printResult(Result result) {
        System.out.println(result.getPrize());
    }
}
