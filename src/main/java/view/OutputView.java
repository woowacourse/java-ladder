package view;

import domain.ladder.Bridge;
import domain.ladder.Bridges;
import domain.ladder.Ladder;
import domain.player.Names;
import java.util.List;
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
}
