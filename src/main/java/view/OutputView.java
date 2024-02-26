package view;

import domain.ladder.Bridge;
import domain.ladder.Bridges;
import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prize;
import domain.result.Prizes;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void printNames(Names names) {
        for (String name : names.getNames()) {
            System.out.printf("%5s ", name);
        }
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
  
    public static void printResults(Prizes result) {
        for (String name : result.getResults()) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printAllResult(Map<Name, Prize> ladderGame) {
        System.out.println("실행결과");
        for (Name name : ladderGame.keySet()) {
            System.out.println(name + " : " + ladderGame.get(name));
        }
    }

    public static void printEachResult(Name name, Prize prize) {
        System.out.println("실행결과");
        System.out.println(name + " : " + prize);
    }
  
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
