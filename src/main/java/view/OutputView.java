package view;

import domain.Bridges;
import domain.Ladder;
import domain.Name;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printNames(List<Name> names) {
        for (Name name : names) {
            System.out.printf("%5s ", name.getName());
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


    private static String getBridgeMessage(boolean hasBridge){
        if(hasBridge){
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }
}
