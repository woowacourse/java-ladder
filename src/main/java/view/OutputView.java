package view;

import domain.MatchingResult;
import domain.ladder.Bridge;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prizes;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNames(Names names) {
        for (Name name : names.getNames()) {
            System.out.printf("%5s ", name.getName());
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            String bridges = line.getBridges()
                    .stream()
                    .map(OutputView::getBridgeMessage)
                    .collect(Collectors.joining("|"));
            System.out.printf("    |%s|\n", bridges);
        }
    }

    private static String getBridgeMessage(Bridge bridge) {
        if (bridge == Bridge.BUILT) {
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }

    public static void printResults(Prizes result) {
        for (String name : result.getResults()) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printAllResult(List<MatchingResult> matchingResults) {
        System.out.println("실행결과");
        for (MatchingResult matchingResult : matchingResults) {
            System.out.println(matchingResult.getName() + " : " + matchingResult.getPrize());
        }
        System.out.println();
    }

    public static void printEachResult(MatchingResult prize) {
        System.out.println("실행결과");
        System.out.println(prize.getName() + " : " + prize.getPrize());
        System.out.println();
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
